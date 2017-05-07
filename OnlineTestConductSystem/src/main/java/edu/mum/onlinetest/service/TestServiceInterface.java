package edu.mum.onlinetest.service;

import java.util.List;

import edu.mum.onlinetest.model.Test;

public interface TestServiceInterface {
	public List<Test>getAllTest(); 
	public Test getTestById(Long i);
	public void saveTest(Test test);
	public void deleteTestById(Long id);
}
