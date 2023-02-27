package br.com.georgefms.bibliotecaSist;

import br.com.georgefms.bibliotecaSist.model.Book;
import br.com.georgefms.bibliotecaSist.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BibliotecaSistApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaSistApplication.class, args);
	}

	//Iniciando o banco com dados de teste
	@Bean
	CommandLineRunner initDataBase(BookRepository bookRepository){
		return args -> {
			bookRepository.deleteAll();
			Book b = new Book();
			b.setName("Testando maximus");
			b.setYear(1978);
			b.setAuthor("jooj ojjo");
			b.setGender("suspense");

			bookRepository.save(b);
		};
	}
}
