package exercise.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	// new query
	User findByUsername(String username);
}
