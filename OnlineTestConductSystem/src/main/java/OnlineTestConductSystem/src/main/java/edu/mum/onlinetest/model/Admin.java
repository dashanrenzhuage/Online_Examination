package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Admin extends Employee {
	@javax.persistence.Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
