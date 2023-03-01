package br.com.georgefms.bibliotecaSist.repository;

import br.com.georgefms.bibliotecaSist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
