package edu.mum.onlinetest.service;

import java.util.List;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.SubCategory;

public interface SubCategoryInterface {
	
	public List<SubCategory>getAllSubCategory();
	public List<SubCategory>getSubcategoryByCategory(Category  category); 
	public SubCategory getSubCategoryByID(Long i);
	public void saveSubCategory(SubCategory subCategory);
	public void deleteSubCategoryByID(Long id);

	public List<SubCategory> getSubCategoriesByCategoryId(Long id);
	public List<SubCategory> getListOfSubCategoryFromCategoryID(Long id);
	


}
