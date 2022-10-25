package exercise.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import exercise.bookstore.domain.Book;
import exercise.bookstore.domain.BookRepository;
import exercise.bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreApplicationTests {

	@Autowired
	private BookRepository bRepo;

	@Test
	public void createNewBook() {
		Book book = new Book("Testi kirja", "Testaaja", 2022, "11111111", 20.9, new Category("Testi"));
		bRepo.save(book);
		assertThat(book.getTitle().equals("Testi kirja"));
	}

	@Test
	public void findFromList() {
		List<Book> books = bRepo.findByTitle("Mato Matalan onnenpäivät");
		assertThat(books.get(0).getAuthor().equals("Richard Scarry"));
		assertThat(books.get(0).getAuthor().endsWith("y"));
	}
}
