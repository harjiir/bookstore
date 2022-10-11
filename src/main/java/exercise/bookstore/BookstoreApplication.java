package exercise.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import exercise.bookstore.domain.Book;
import exercise.bookstore.domain.BookRepository;
import exercise.bookstore.domain.Category;
import exercise.bookstore.domain.CategoryRepository;
import exercise.bookstore.domain.User;
import exercise.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	// new logger attribute
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// Test data for H2- testdatabase everytime it's started
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepo, CategoryRepository categoryRepo,
			UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");

			// some test categories
			Category kids = new Category("Kids");
			categoryRepo.save(kids);
			Category fc = new Category("Food & Cooking");
			categoryRepo.save(fc);
			Category textbook = new Category("Textbook");
			categoryRepo.save(textbook);

			// some test books with categories
			bookRepo.save(new Book("Mato Matalan onnenpäivät", "Richard Scarry", 2019, "9789520404680", 23.80, kids));
			bookRepo.save(new Book("Björck & Aasia", "Tomi Björck", 2019, "9789527054925", 24.00, fc));
			bookRepo.save(new Book("Bios 3 (OPS16): Solu ja perinnöllisyys",
					"Päivi Happonen, Mervi Holopainen, Panu Sotkas and others", 2017, "9789526342481", 39.60,
					textbook));

			// Create new test users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : bookRepo.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
