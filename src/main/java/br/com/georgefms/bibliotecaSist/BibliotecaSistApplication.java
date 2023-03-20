package br.com.georgefms.bibliotecaSist;

import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.model.User;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import br.com.georgefms.bibliotecaSist.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BibliotecaSistApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaSistApplication.class, args);
		//Senha encriptada para teste
		System.out.println(new BCryptPasswordEncoder().encode("master123"));
	}

}
