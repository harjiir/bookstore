package exercise.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// database interface
public interface BookRepository extends CrudRepository<Book, Long> {

	// extending CrudRepository the BookRepository inherits
	// methods for example saving, deleting, and finding Book entities
	List<Book> findByTitle(String title);

}
