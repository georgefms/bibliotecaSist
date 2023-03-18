package br.com.georgefms.bibliotecaSist.controller;

import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.model.User;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import br.com.georgefms.bibliotecaSist.repository.UserRepository;
import br.com.georgefms.bibliotecaSist.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
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

    @Autowired
    private BooksService bookService;

    //Get todos os livros
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Book> getAllBooks(Authentication auth){
        return bookService.getAllBooks(auth);
    }

    //Get por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Book> findById(@PathVariable @NotNull @Positive Long id){
        return bookService.findById(id);
    }

    //Post de um livro
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Book  postBook(@RequestBody @Valid Book book, Authentication authentication){
        return bookService.createBook(book, authentication);

    }

    //Put de um registro
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
//    public Book putBook(@PathVariable Long id, @Valid @RequestBody Book bookRequest, Authentication auth){
//        String username = auth.getName();
//        boolean isAdmin = auth.getAuthorities().stream()
//                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
//        return BooksService.updateBook(id, bookRequest, username, isAdmin);
//    }
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book bookRequest, Authentication authentication) {
        String username = authentication.getName();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        return bookService.updateBook(id, bookRequest, username, isAdmin);
    }
    //Delete de livros
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    /*
     * O boleano isAdmin compara se o utilizador logado tem a role admin e permite a exclusão de qualquer registro
     */
    public ResponseEntity<Void> deleteBook(@PathVariable Long id, Authentication auth){
        String username = auth.getName();
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        bookService.deleteBook(id, username, isAdmin);
        return ResponseEntity.noContent().build();
    }

}
