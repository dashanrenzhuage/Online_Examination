package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
	
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	private String name;

	
	private boolean flag =true;
	
	



	@JsonBackReference

	@OneToMany( cascade = CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="category")

	private List<SubCategory>subcategories;
	
	public List<SubCategory> getSubcategories() {
		return subcategories;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
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
