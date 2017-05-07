package edu.mum.onlinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.CategoryServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;
@Controller
@RequestMapping("/subCategories")
public class SubCategoryController {
	
		@Autowired
		SubCategoryInterface subCategoryService;
	
		@Autowired
		CategoryServiceInterface categoryService;
		
		// Get all Category------
		
		@RequestMapping(value = "/getSubCategoryFromCategory/{id}", method = RequestMethod.GET)
		public @ResponseBody List<SubCategory> getSubCategoryByCategory(@RequestBody @PathVariable("id") Long id){
			System.out.println("--------------category---------herhe");
			List<SubCategory> listOfSubcategories = subCategoryService.getListOfSubCategoryFromCategoryID(id);
			for(SubCategory l : listOfSubcategories){
				System.out.println(l.getSubCatName());
			}
			
			return listOfSubcategories;
			
		}
		
		
		 @RequestMapping(method = RequestMethod.GET)
		    public ResponseEntity<List<SubCategory>> getAll() {
		       /* LOG.info("getting all categories");*/
		        List<SubCategory> subcategories = subCategoryService.getAllSubCategory();

		        subcategories.forEach(s->{
		        	System.out.println(s);
		        });


		        return new ResponseEntity<List<SubCategory>>(subcategories, HttpStatus.OK);
		    }

		//Get category by ID------
		 
		 @RequestMapping(value = "{id}", method = RequestMethod.GET)
		    public ResponseEntity<SubCategory> get(@PathVariable("id") Long id){
		       
			 SubCategory subCategory = subCategoryService.getSubCategoryByID(id);

		     

		        return new ResponseEntity<SubCategory>(subCategory, HttpStatus.OK);
		    }

		 //Add category ------
		 
		 @RequestMapping(method = RequestMethod.POST)
		    public ResponseEntity<Void> create(@RequestBody SubCategory subCategory, UriComponentsBuilder ucBuilder){
			 subCategory.setCategory(categoryService.getCategoryByID((long) 8));
			subCategoryService.saveSubCategory(subCategory);
		        HttpHeaders headers = new HttpHeaders();
		        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }

}
