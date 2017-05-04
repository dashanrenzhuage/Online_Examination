package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubCategory {
	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	
	private String subCategoryName;
	private String grade;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Question>questions;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	@Override
	public String toString() {
		return "SubCategory [Id=" + Id + ", subCategoryName=" + subCategoryName + ", questions=" + questions + "]";
	}
	
	

}
