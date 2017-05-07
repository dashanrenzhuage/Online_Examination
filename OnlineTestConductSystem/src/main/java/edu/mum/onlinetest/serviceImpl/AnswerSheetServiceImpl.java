package edu.mum.onlinetest.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.model.Answer;
import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.model.Question;

@Service
public class AnswerSheetServiceImpl {
	
	@Autowired
	TestServiceImpl testService;

	public Integer getResult(List<Integer> answers, Long testId) {
		
		List<Integer> individualMarks = new ArrayList<>();
		Integer marks = 0;
		int noOfQuestions = testService.getTestById(testId).getQuestionList().size();
		int noOfSubCategory = testService.getTestById(testId).getSubCategories().size();
		
		int number = noOfQuestions/noOfSubCategory;
		
		
		for (int i = 0; i < noOfQuestions; i++){
			int noOfOptions = testService.getTestById(testId).getQuestionList().get(i).getOpts().size();
			for(int j = 0; j < noOfOptions; j++)
			if(testService.getTestById(testId).getQuestionList().get(i).getOpts().get(j).isCorrect()){
				if(answers.get(i) == j){
					// Add marks
					testService.getTestById(testId).setTotalmarks((testService.getTestById(testId).getTotalmarks()+1));
					
					
				}
			}
		}
		return marks;
		
	}
	
	

}
