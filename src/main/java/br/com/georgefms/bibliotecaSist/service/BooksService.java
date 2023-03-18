package br.com.georgefms.bibliotecaSist.service;

import br.com.georgefms.bibliotecaSist.exception.BookNotFoundException;
import br.com.georgefms.bibliotecaSist.exception.UnauthorizedException;
import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksService {

    BookRepository bookRepository;

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

    public void deleteBook(Long id, String createdBy, Boolean isAdmin){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        if (!isAdmin && !book.getCreatedBy().equals(createdBy)){
            throw new UnauthorizedException();
        }
        bookRepository.delete(book);
    }
}
