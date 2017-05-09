package edu.mum.onlinetest.serviceImpl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.onlinetest.dao.CategoryDao;
import edu.mum.onlinetest.dao.SubCategoryDao;
import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.SubCategoryInterface;

@Service
@Transactional
public class SubCategoryImpl implements SubCategoryInterface {

	@Autowired
	SubCategoryDao dao;

	@Override
	public List<SubCategory> getAllSubCategory() {
		List<SubCategory> subCategories = (List<SubCategory>) dao.getAllSubCategory();
		for(SubCategory subCategory: subCategories){
			Logger.getLogger("Category contains subcategories size:"+subCategory.getSubCatName());
    	}
		return subCategories;
	}

	@Override
	public SubCategory getSubCategoryByID(Long id) {
		return dao.findOne(id);
	}

	

	
	@Override
	public void saveSubCategory(SubCategory subCategory) {
		dao.save(subCategory);
		
	}

	@Override
	public void deleteSubCategoryByID(Long id) {
		dao.delete(id);
		
	}

	@Override

	public List<SubCategory> getSubCategoriesByCategoryId(Long id) {
		return dao.getSubCategoriesByCategoryId(id);
		
	}

	

	public List<SubCategory> getSubcategoryByCategory(Category  category) {
		return dao.getSubcategoryByCategory(category);
	}

	@Override
	public List<SubCategory> getListOfSubCategoryFromCategoryID(Long id) {
		return dao.findBySubCategoryFromCategory(id);
	}

}
