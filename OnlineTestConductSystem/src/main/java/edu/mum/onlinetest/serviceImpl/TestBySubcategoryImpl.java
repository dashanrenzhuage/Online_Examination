package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.TestBySubcatDao;
import edu.mum.onlinetest.model.TestBySubCategory;
import edu.mum.onlinetest.service.TestByCategoryService;

@Service
public class TestBySubcategoryImpl implements TestByCategoryService{

	
	@Autowired
	TestBySubcatDao dao;
	
	@Override
	public List<TestBySubCategory> getAllTestQuestion() {
		// TODO Auto-generated method stub
		return (List<TestBySubCategory>) dao.findAll();
	}

	@Override
	public TestBySubCategory getTestBySubCategoryByID(Long id) {
		
		return dao.findOne(id);
	}

	@Override
	public void saveTestBySubCategory(TestBySubCategory testQuestion) {
		dao.save(testQuestion);
		
	}

	@Override
	public void deleteTestBySubCategoryByID(Long id) {
	dao.delete(id);
		
	}

}
