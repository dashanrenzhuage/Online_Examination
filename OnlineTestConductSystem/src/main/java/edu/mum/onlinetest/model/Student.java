package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student extends Person{

	
	private String email;

	private String accessCode;
	
	private String phoneNo;
	
	@OneToOne
	private Coach coach;
	
	/*public Admin getCoach() {
		return coach;
	}

	public void setCoach(Admin coach) {
		this.coach = coach;
	}*/

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}


	
	
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
