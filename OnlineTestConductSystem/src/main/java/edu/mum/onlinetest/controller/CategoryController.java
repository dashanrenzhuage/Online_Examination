package edu.mum.onlinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.service.CategoryServiceInterface;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryServiceInterface categoryService;
	
	// Get all Category------
	
	 @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<List<Category>> getAll() {
	     
	        List<Category> categories = categoryService.getAllCategory();
	        

	       /* if (categories == null || categories.isEmpty()){
	            LOG.info("no category found");
	            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
	        }*/

	        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	    }

	//Get category by ID------
	 
	 @RequestMapping(value = "{id}", method = RequestMethod.GET)
	    public ResponseEntity<Category> get(@PathVariable("id") Long id){
	       
		 Category category = categoryService.getCategoryByID(id);

	        /*if (user == null){
	            LOG.info("Category with id {} not found", id);
	            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	        }*/

	        return new ResponseEntity<Category>(category, HttpStatus.OK);
	    }

	 //Add category ------
	 
	 @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Void> create(@RequestBody Category category, UriComponentsBuilder ucBuilder){
		 categoryService.saveCategory(category);
	        HttpHeaders headers = new HttpHeaders();
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
	 //Update existing category-----
	 
	 @RequestMapping(value = "{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category){
	       // LOG.info("updating category: {}", category);
		 Category currentCategory = categoryService.getCategoryByID(id);

	      /*  if (currentCategory == null){
	            LOG.info("Category with id {} not found", id);
	            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	        }
*/
	        
	        categoryService.saveCategory(currentCategory);
	        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
	    }
	 
	 // Delete category -----
	 
	 @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
	        //LOG.info("deleting category with id: {}", id);
		 Category category = categoryService.getCategoryByID(id);

	        if (category == null){
	          //  LOG.info("Unable to delete. Category with id {} not found", id);
	        	
	            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	        }

	        categoryService.deleteCategoryByID(id);
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
	

}
