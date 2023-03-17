package br.com.georgefms.bibliotecaSist.controller;

import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.model.User;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import br.com.georgefms.bibliotecaSist.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/books")
//Instanciando o repositório
@AllArgsConstructor
public class BooksController {

    private final BookRepository bookRepository;

    //Get todos os livros
    @GetMapping
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Book> list(){
        return bookRepository.findAll();
    }

    //Get por ID
    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Book> findById(@PathVariable @NotNull @Positive Long id){
        return bookRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound)).
                orElse(ResponseEntity.notFound().build());
    }

    //Post de um livro
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Book  create(@RequestBody @Valid Book book, Authentication authentication){
        book.setCreatedBy(authentication.getName());
        return bookRepository.save(book);

    }

    //Put de um registro
    @PutMapping("/{id}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Book> update(@PathVariable @NotNull @Positive Long id, @RequestBody Book book){
        return bookRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(book.getName());
                    recordFound.setAuthor(book.getAuthor());
                    recordFound.setYear(book.getYear());
                    recordFound.setGender(book.getGender());
                    Book updated = bookRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                }).
                orElse(ResponseEntity.notFound().build());
    }

    //Delete de livros
    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id){
        return bookRepository.findById(id)
                .map(recordFound -> {
                    bookRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
