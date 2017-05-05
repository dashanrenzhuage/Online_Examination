package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
	
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	private String name;
	
	
	@OneToMany( cascade = CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="category")
	private List<SubCategory>subcategories;
	
	public List<SubCategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<SubCategory> subcategories) {
		this.subcategories = subcategories;
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
	
}
