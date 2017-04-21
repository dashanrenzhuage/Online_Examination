package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	@Column(columnDefinition= "Text")
	private String question;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Opts> getOpts() {
		return opts;
	}
	public void setOpts(List<Opts> opts) {
		this.opts = opts;
	}
	@OneToMany
	private List<Opts>opts;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	

}
