package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@javax.persistence.Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private Question question;
	@OneToOne
	private Opts answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Opts getAnswer() {
		return answer;
	}
	public void setAnswer(Opts answer) {
		this.answer = answer;
	}
	
	
	
	/*
	private Long testid;
	private Long questionid;
	private Long answerid;
	public Long getTestid() {
		return testid;
	}
	public void setTestid(Long testid) {
		this.testid = testid;
	}
	public Long getQuestionid() {
		return questionid;
	}
	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}
	public Long getAnswerid() {
		return answerid;
	}
	public void setAnswerid(Long answerid) {
		this.answerid = answerid;
	}
	
	*/
	
}
