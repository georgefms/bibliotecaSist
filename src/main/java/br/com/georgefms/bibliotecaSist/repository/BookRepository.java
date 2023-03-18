package br.com.georgefms.bibliotecaSist.repository;

import br.com.georgefms.bibliotecaSist.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.createdBy = :username")
    List<Book> findByCreatedBy(@Param("username") String username);
}
