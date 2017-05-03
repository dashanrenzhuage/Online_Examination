package edu.mum.onlinetest.service;

import java.util.List;


import edu.mum.onlinetest.model.SubCategory;

public interface SubCategoryInterface {
	
	public List<SubCategory>getAllSubCategory(); 
	public SubCategory getSubCategoryByID(Long i);
	public void saveSubCategory(SubCategory subCategory);
	public void deleteSubCategoryByID(Long id);


}
