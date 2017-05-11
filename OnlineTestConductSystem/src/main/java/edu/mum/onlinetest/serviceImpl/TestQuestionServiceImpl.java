package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.TestQuestionDao;
import edu.mum.onlinetest.model.TestQuestion;
import edu.mum.onlinetest.service.TestQuestionServiceInterface;

@Service
public class TestQuestionServiceImpl implements TestQuestionServiceInterface {

	@Autowired
	TestQuestionDao dao;

	@Override
	public List<TestQuestion> getAllTestQuestion() {

		return (List<TestQuestion>) dao.findAll();
	}

	@Override
	public TestQuestion getTestQuestionByID(Long id) {

		return dao.findOne(id);
	}

	@Override
	public void saveTestQuestion(TestQuestion testQuestion) {
		dao.save(testQuestion);

	}

	@Override
	public void deleteTestQuestionByID(Long id) {
		dao.delete(id);
	}

}
