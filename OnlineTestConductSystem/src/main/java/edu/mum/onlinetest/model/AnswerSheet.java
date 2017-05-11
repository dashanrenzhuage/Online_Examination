package edu.mum.onlinetest.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AnswerSheet {
	@javax.persistence.Id
	@GeneratedValue
	private int id;
	
	@OneToMany
	private List<Answer>answerList;
	private int marks;
	
	/*@OneToOne
	private List<Question> questions;
	*/
	/*@OneToOne
	private Test test;
	*/
	
	
	/*private int obtainedTotalMarks;
	private Map<String, Integer> eachSubCategoryMarksObtained;*/
	
	
	
	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	/*
	
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}*/
	/*public int getObtainedTotalMarks() {
		return obtainedTotalMarks;
	}
	public void setObtainedTotalMarks(int obtainedTotalMarks) {
		this.obtainedTotalMarks = obtainedTotalMarks;
	}
	public Map<String, Integer> getEachSubCategoryMarksObtained() {
		return eachSubCategoryMarksObtained;
	}
	public void setEachSubCategoryMarksObtained(Map<String, Integer> eachSubCategoryMarksObtained) {
		this.eachSubCategoryMarksObtained = eachSubCategoryMarksObtained;
	}*/
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
	
	/*int marks;

	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}*/
	
	

}
