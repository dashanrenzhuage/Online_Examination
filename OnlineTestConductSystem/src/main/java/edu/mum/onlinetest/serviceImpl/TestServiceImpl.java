package edu.mum.onlinetest.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.TestDao;
import edu.mum.onlinetest.model.Test;
import edu.mum.onlinetest.service.TestServiceInterface;

@Service
public class TestServiceImpl implements TestServiceInterface{

	@Autowired
	TestDao dao;
	
	@Override
	public List<Test> getAllTest() {
		List<Test> tests = (List<Test>) dao.findAll();
		return tests;
	}

	@Override
	public Test getTestById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void saveTest(Test test) {
		dao.save(test);
	}

	@Override
	public void deleteTestById(Long id) {
		dao.delete(id);
	}

}
