package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.AnswerDao;
import edu.mum.onlinetest.model.Answer;
import edu.mum.onlinetest.model.TestQuestion;
import edu.mum.onlinetest.service.AnswerServiceInterface;

@Service
public class AnswerServiceImpl implements AnswerServiceInterface {

	
	@Autowired
	AnswerDao dao;
	@Override
	public List<Answer> getAllAnswer() {
		
		return (List<Answer>) dao.findAll();
	}

	@Override
	public Answer getAnswernByID(Long id) {
		
		return dao.findOne(id);
	}

	@Override
	public void saveAnswer(Answer answer) {
		dao.save(answer);
		
	}

	@Override
	public void deleteAnswerByID(Long id) {
		dao.delete(id);
	}

}
