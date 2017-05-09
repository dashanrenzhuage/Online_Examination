package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Entity
public class TestQuestion {
	
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Question question;
	@OneToOne
	private Opts slectedOption;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Opts getSlectedOption() {
		return slectedOption;
	}

	public void setSlectedOption(Opts slectedOption) {
		this.slectedOption = slectedOption;
	}

	
}
