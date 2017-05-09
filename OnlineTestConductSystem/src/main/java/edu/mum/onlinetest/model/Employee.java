package edu.mum.onlinetest.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public  class Employee {
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String fName;
	@NotEmpty
	private String lName;
	
	/*@OneToOne
	@Valid
	private Address adress;*/
	 
	
	@OneToOne(cascade = CascadeType.ALL)
	private Credential credential;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	/*public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	

}
