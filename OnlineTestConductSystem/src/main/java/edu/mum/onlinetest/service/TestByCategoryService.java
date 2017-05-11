package edu.mum.onlinetest.service;

import java.util.List;

import edu.mum.onlinetest.model.TestBySubCategory;


public interface TestByCategoryService {
	public List<TestBySubCategory>getAllTestQuestion(); 
	public TestBySubCategory getTestBySubCategoryByID(Long id);
	public void saveTestBySubCategory(TestBySubCategory testQuestion);
	public void deleteTestBySubCategoryByID(Long id);

}
