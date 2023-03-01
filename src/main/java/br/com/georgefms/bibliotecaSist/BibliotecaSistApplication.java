package br.com.georgefms.bibliotecaSist;

import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.model.User;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import br.com.georgefms.bibliotecaSist.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BibliotecaSistApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaSistApplication.class, args);
	}

	//Iniciando com  dados para teste.
//	@Bean
//	CommandLineRunner initDataBase(BookRepository bookRepository, UserRepository userRepository){
//		return args -> {
//			bookRepository.deleteAll();
//			Book b = new Book();
//			b.setName("Testando maximus");
//			b.setYear(1978);
//			b.setAuthor("jooj ojjo");
//			b.setGender("suspense");
//			bookRepository.save(b);
//			userRepository.deleteAll();
//			User a = new User();
//			a.setNick("Admin");
//			a.setPassword("12345678");
//			a.setRole("Admin");
//			userRepository.save(a);
//		};
//	}
}
