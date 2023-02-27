package br.com.georgefms.bibliotecaSist.controller;

import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
//Instanciando o repositório
@AllArgsConstructor
public class BooksController {

    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> list(){
        return bookRepository.findAll();
    }
}
