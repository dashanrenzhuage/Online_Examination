package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Category {
	
	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	private String name;
	
	@OneToMany
	private List<SubCategory>subcategories;
	public List<SubCategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
