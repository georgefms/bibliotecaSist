package br.com.georgefms.bibliotecaSist.service;

import br.com.georgefms.bibliotecaSist.exception.BookNotFoundException;
import br.com.georgefms.bibliotecaSist.exception.UnauthorizedException;
import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Service
@AllArgsConstructor
public class BooksService {

    @Autowired
    BookRepository bookRepository;

    /*
    * getAllBooks(autenticacao)
    * Funcao responsável por realizar o get em livros e, para o usuario, listar primeiros os livros que o mesmo criou.
    * */
    public List<Book> getAllBooks(Authentication authentication){
        List<Book> books;
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            books = bookRepository.findAll();
        } else {
            String username = authentication.getName();
            books = bookRepository.findByCreatedBy(username);
            books.addAll(bookRepository.findAll());
        }
        return books;
    }

    /*
     *deleteBook( id: id do livro a ser exluído,
     * createdBy: string com o nome do criador, isAdmin: verificação por role)
     */
    public void deleteBook(Long id, String createdBy, Boolean isAdmin){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        if (!isAdmin && !book.getCreatedBy().equals(createdBy)){
            throw new UnauthorizedException();
        }
        bookRepository.delete(book);
    }

    public Book updateBook(Long id, Book bookRequest, String username, Boolean isAdmin){
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        if(!isAdmin && !book.getCreatedBy().equals(username)){
            throw new UnauthorizedException();
        }
        book.setName(bookRequest.getName());
        book.setAuthor(bookRequest.getAuthor());
        book.setYear(bookRequest.getYear());
        book.setGender(bookRequest.getGender());

        return bookRepository.save(book);
    }

    public Book  createBook(Book book, Authentication authentication){
        book.setCreatedBy(authentication.getName());
        return bookRepository.save(book);
    }

    public ResponseEntity<Book> findById(Long id){
        return bookRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound)).
                orElse(ResponseEntity.notFound().build());
    }
}
