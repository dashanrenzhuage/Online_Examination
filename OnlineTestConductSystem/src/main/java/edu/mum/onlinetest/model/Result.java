package edu.mum.onlinetest.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Entity
public class Result {
	
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	private int totalMarks;
	@OneToMany
	List<SubCategoryGrade> subCategoryGrades;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public List<SubCategoryGrade> getSubCategoryGrades() {
		return subCategoryGrades;
	}
	public void setSubCategoryGrades(List<SubCategoryGrade> subCategoryGrades) {
		this.subCategoryGrades = subCategoryGrades;
	}
	
	
}
