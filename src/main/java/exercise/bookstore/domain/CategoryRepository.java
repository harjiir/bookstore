package exercise.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//database interface
public interface CategoryRepository extends CrudRepository<Category, Long> {

	// extending CrudRepository the CategoryRepository inherits
	// methods for example saving, deleting, and finding Category entities
	List<Category> findByCategoryName(String categoryName);
}
