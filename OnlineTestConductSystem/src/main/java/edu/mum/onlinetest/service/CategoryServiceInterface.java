package edu.mum.onlinetest.service;

import java.util.List;

import edu.mum.onlinetest.model.Category;


public interface CategoryServiceInterface {
	public List<Category>getAllCategory(); 
	public Category getCategoryByID(Long id);
	public void saveCategory(Category category);
	public void deleteCategoryByID(Long id);

}
