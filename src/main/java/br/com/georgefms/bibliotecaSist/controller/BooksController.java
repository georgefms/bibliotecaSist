package br.com.georgefms.bibliotecaSist.controller;

import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
//Instanciando o repositório
@AllArgsConstructor
public class BooksController {

    private final BookRepository bookRepository;

    //Get todos os livros
    @GetMapping
    public List<Book> list(){
        return bookRepository.findAll();
    }

    //Get por ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return bookRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record)).
                orElse(ResponseEntity.notFound().build());
    }

    //Post de um livro
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }
}
