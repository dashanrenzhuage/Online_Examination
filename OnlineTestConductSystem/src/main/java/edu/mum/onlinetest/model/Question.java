package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Question {
	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	
	@OneToMany
	private List<Opts>opts;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	

}
