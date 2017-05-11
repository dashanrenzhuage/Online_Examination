package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TestBySubCategory {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	SubCategory subCat;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SubCategory getSubCat() {
		return subCat;
	}

	public void setSubCat(SubCategory subCat) {
		this.subCat = subCat;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	private int marks;

}
