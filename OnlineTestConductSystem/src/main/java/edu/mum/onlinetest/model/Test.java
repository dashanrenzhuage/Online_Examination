package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Test {
	@javax.persistence.Id
	@GeneratedValue
	private int id;
	@OneToOne
	private AnswerSheet answersheet;
	@OneToMany
	private List<Question>questionList;
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public AnswerSheet getAnswersheet() {
		return answersheet;
	}
	public void setAnswersheet(AnswerSheet answersheet) {
		this.answersheet = answersheet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
