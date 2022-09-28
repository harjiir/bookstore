package exercise.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	private String categoryName;

	// @ManyToOne or @OneToMany = defines a relationship between two entities
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;

	// empty category
	public Category() {
	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	// getters for category
	public Long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	// setters for category
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	// getters and setters for Book
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		// Do not insert list attribute books here! Otherwise --> infinite loop
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}