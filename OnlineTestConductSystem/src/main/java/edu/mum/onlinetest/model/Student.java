package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student extends Person{

	
	private String email;
	private String accessId;
	
	

	@OneToOne
	private Test test;
	@OneToOne
	private Report report;
	
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}
}
