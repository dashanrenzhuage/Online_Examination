package edu.mum.onlinetest.service;

import java.util.List;

import edu.mum.onlinetest.model.Answer;


public interface AnswerServiceInterface {
	public List<Answer>getAllAnswer(); 
	public Answer getAnswernByID(Long id);
	public void saveAnswer(Answer answer);
	public void deleteAnswerByID(Long id);


}
