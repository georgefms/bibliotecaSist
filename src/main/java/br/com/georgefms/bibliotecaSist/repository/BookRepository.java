package br.com.georgefms.bibliotecaSist.repository;

import br.com.georgefms.bibliotecaSist.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
