package edu.mum.onlinetest.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class QuestionOptions {
	@javax.persistence.Id
	@GeneratedValue
	private int id;
	
	private String options;
	private boolean isCorrect;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	
	

}
