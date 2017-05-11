package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Test {
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	
	
	
	@OneToOne
	private Student student;
	
	
	
	
	@OneToMany(cascade= CascadeType.ALL)
	
	List<TestBySubCategory> testSubcat;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	/*@OneToMany
	private List<Question>questionList;*/
	
	private int totalmarks;
	
	
	/*public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}*/
	/*public AnswerSheet getAnswersheet() {
		return answersheet;
	}
	public void setAnswersheet(AnswerSheet answersheet) {
		this.answersheet = answersheet;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	/*public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}*/
	public int getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}
	
	
	
	

}
