package exercise.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import exercise.bookstore.domain.Book;
import exercise.bookstore.domain.BookRepository;
import exercise.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

	// @Autowired annotation bring repository class into the context,
	// will inject an instance of the service into the YourAppClass class.
	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	// All books
	@GetMapping("/booklist")
	public String listBooks(Model model) {
		// All books are fetched from the database and added to the model attribute
		model.addAttribute("books", bookRepo.findAll());
		return "booklist"; // booklist.html
	}

	// Add book
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		// add category to book
		model.addAttribute("categories", categoryRepo.findAll());
		return "addbook"; // addbook.html
	}

	// Save book
	// Redirect to booklist after adding new book with a form
	@PostMapping("/save")
	public String saveBook(Book book) {
		bookRepo.save(book);
		return "redirect:booklist"; // redirect to booklist
	}

	// Delete book and redirect back to listing books
	@GetMapping("/deletebook/{id}")
	// @PathVariable extracts id from the URI
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepo.deleteById(id);
		return "redirect:../booklist"; // redirect to booklist
	}

	// Edit book
	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("bookInEdit", bookRepo.findById(id));
		// give categories to model
		model.addAttribute("categories", categoryRepo.findAll());
		return "editbook"; // editbook.html
	}
}