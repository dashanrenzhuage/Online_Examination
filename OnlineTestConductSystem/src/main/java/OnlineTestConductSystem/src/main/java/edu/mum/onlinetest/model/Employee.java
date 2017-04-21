package edu.mum.onlinetest.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("E")
public abstract class Employee extends Person{
	@javax.persistence.Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Credential credential;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	

}
