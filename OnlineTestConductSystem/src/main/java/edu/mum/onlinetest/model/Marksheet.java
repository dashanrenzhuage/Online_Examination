package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Entity
public class Marksheet {
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	private Long studentId;
	private String name;
	private String email;
	private String testDate;
	private String address;
	private String grade;
	
	
	private String category;
	private String subCategoryName;
	
	
	
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "Marksheet [id=" + id + ", studentId=" + studentId + ", name=" + name + ", email=" + email
				+ ", testDate=" + testDate + ", address=" + address + ", grade=" + grade
				+ "]";
	}
	
	
}
