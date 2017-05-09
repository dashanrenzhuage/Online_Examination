package edu.mum.onlinetest.service;

import java.util.List;


import edu.mum.onlinetest.model.TestQuestion;

public interface TestQuestionServiceInterface {
	public List<TestQuestion>getAllTestQuestion(); 
	public TestQuestion getTestQuestionByID(Long id);
	public void saveTestQuestion(TestQuestion testQuestion);
	public void deleteTestQuestionByID(Long id);


}
