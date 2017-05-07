package edu.mum.onlinetest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
	
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	@Column(columnDefinition= "Text")
	/*@JsonProperty("questionName")*/
	private String quesName;
	
//	@OneToOne(fetch=FetchType.EAGER)
	@OneToOne
	@JsonIgnore
	private SubCategory subCategory;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Opts> opts;
	
	
	public String getQuesName() {
		return quesName;
	}

	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}
	
	public List<Opts> getOpts() {
		return opts;
	}

	public void setOpts(List<Opts> opts) {
		this.opts = opts;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/*@Override
	public String toString() {
		return "Question [id=" + id + ", quesName=" + quesName + "]";
	}*/

	/*@Override
	public String toString() {
		return "Question [id=" + id + ", quesName=" + quesName + ", subCategory=" + subCategory + ", opts=" + opts
				+ "]";
	}*/
	
	/*@Override
	public String toString() {
		return "Question [id=" + id + ", quesName=" + quesName + ", subCategory=" + subCategory + ", opts=" + opts
				+ ", getQuesName()=" + getQuesName() + ", getSubCategory()=" + getSubCategory() + ", getOpts()="
				+ getOpts() + ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}*/

}
