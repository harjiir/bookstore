package exercise.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// @Entity represents a table in relational database
// Can be changed by using @Table annotation

@Entity
public class Book {

	// @Id = creating id column of the table
	// @GeneratedValue = generates automatically a unique primary key for every new
	// entity object
	// @Column(name = "") can change column name
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // new attribute id
	private String title;
	private String author;
	@Column(name = "published") // changes year -column name
	private int year;
	private String isbn;
	private double price;

	// @ManyToOne or @OneToMany = defines a relationship between two entities
	// @JoinColumn = defines the owner of the relationship
	// (Category categoryId is now FK in Book table)
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	// empty book
	public Book() {
	}

	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	// getters for Book
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}

	// setters for Book
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// getters and setters for Category
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// toString
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
					+ ", price=" + price + "category=" + this.getCategory() + "]";
		else
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
					+ ", price=" + price + "]";
	}
}