package edu.mum.onlinetest.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AnswerSheet {
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
	private List<Answer>answerList;
	private int marks;
	
	@OneToMany(cascade=CascadeType.ALL)
	@MapKey(name="subCatName")
	private Map<Integer, SubCategory> marksBySubcategory;
	
	
	
	
	public Map<Integer, SubCategory> getMarksBySubcategory() {
		return marksBySubcategory;
	}

	public void setMarksBySubcategory(Map<Integer, SubCategory> marksBySubcategory) {
		this.marksBySubcategory = marksBySubcategory;
	}

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
