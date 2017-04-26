package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.CategoryDao;
import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.service.CategoryServiceInterface;

@Service
public class CategoryServiceImpl implements CategoryServiceInterface{
	
	
	@Autowired
	CategoryDao dao;

	public List<Category> getAllCategory() {
		return (List<Category>) dao.findAll();
	}

	public Category getCategoryByID(Long id) {
		return dao.findOne(id);
	}

	

	public void deleteCategoryByID(Long id) {
		dao.delete(id);
		
	}

	public void saveCategory(Category category) {
		dao.save(category);
		
	}

	

}
