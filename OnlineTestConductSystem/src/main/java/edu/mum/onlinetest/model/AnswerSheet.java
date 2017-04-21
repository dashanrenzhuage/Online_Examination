package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Entity
public class AnswerSheet {
	@javax.persistence.Id
	@GeneratedValue
	private int id;
	@OneToMany
	private List<Answer>answerList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	

}