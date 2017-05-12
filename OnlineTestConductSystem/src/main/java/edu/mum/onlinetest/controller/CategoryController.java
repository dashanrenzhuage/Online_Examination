package edu.mum.onlinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.service.CategoryServiceInterface;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryServiceInterface categoryService;

	// Get all Category------

	@RequestMapping(method = RequestMethod.GET)
	// public ResponseEntity<List<Category>> getAll(Model model) {
	public String getAll(Model model) {

		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("listOfCategory", categories);
		return "coach_home_page";

	}

	// Get category by ID------

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> get(@PathVariable("id") Long id) {

		Category category = categoryService.getCategoryByID(id);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		System.out.println("*****************here");
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("listOfCategory", categories);
		return "add_category";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(@ModelAttribute Category category, BindingResult result, RedirectAttributes rd) {
		System.out.println("category controller");
		List<Category> categories = categoryService.getAllCategory();
		for(int i=0; i<categories.size(); i++){
			if(category.getName().equals(categories.get(i).getName())){
				rd.addFlashAttribute("message", "Already exist category");
				return "redirect:/category/add";
			}
		}
		categoryService.saveCategory(category);
		// HttpHeaders headers = new HttpHeaders();
		rd.addFlashAttribute("message", "category successfully added!");
		return "redirect:/category/add";
	}

	// Update existing category-----

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
		Category currentCategory = categoryService.getCategoryByID(id);
		categoryService.saveCategory(currentCategory);
		return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
	}

	// Delete category -----

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		// LOG.info("deleting category with id: {}", id);
		Category category = categoryService.getCategoryByID(id);

		if (category == null) {
			// LOG.info("Unable to delete. Category with id {} not found", id);

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		categoryService.deleteCategoryByID(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
