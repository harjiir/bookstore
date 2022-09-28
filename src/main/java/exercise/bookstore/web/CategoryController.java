package exercise.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import exercise.bookstore.domain.Category;
import exercise.bookstore.domain.CategoryRepository;

public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;

	// All categories
	@GetMapping("/categorylist")
	public String listCategories(Model model) {
		// All categories are fetched from the database and added to the model attribute
		model.addAttribute("categories", categoryRepo.findAll());
		return "categorylist"; // categorylist.html
	}

	// Add category
	@GetMapping("/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory"; // addcategory.html
	}

	// Redirect to categorylist after adding new category with a form
	@PostMapping("/saveCategory")
	public String saveCategory(Category category) {
		categoryRepo.save(category);
		return "redirect:categorylist"; // redirect to categorylist
	}
}
