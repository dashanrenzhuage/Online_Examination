package edu.mum.onlinetest.service;

import java.util.List;

import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.model.Question;

public interface AnswerSheetInterface {
	
	public List<AnswerSheet>getAllAnswerSheet(); 
	public AnswerSheet getAnswerSheetByID(Long id);
	public void saveAnswerSheet(AnswerSheet answerSheet);
	public void deleteAnswerSheetByID(Long id);
	public int getResult(AnswerSheet answerSheet2, Long id);
	

}
