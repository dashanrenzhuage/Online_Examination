package edu.mum.onlinetest.serviceImpl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.onlinetest.dao.CategoryDao;
import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.CategoryServiceInterface;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryServiceInterface {

	@Autowired
	CategoryDao dao;

	@Override
	public List<Category> getAllCategory() {

		List<Category> categories = (List<Category>) dao.getAllCategory();

		/*
		 * for(Category category: categories){
		 * Logger.getLogger("Category contains subcategories size:"+category.
		 * getSubcategories().size()); for(SubCategory subCategory:
		 * category.getSubcategories()){ //
		 * Logger.getLogger("Category contains subcategories size:"+subCategory.
		 * getQuestions().size());
		 * Logger.getLogger("Category contains subcategories:"+subCategory.
		 * getSubCatName()); } }
		 */

		return categories;
	}

	@Override
	public Category getCategoryByID(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void deleteCategoryByID(Long id) {
		dao.delete(id);

	}

	@Override
	public void saveCategory(Category category) {
		dao.save(category);

	}

}
