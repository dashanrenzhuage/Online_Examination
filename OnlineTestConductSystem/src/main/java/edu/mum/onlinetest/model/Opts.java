package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Opts {
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	private String options;
	private Boolean isCorrectAns = false;

	public Boolean getIsCorrectAns() {
		return isCorrectAns;
	}

	public void setIsCorrectAns(Boolean isCorrectAns) {
		this.isCorrectAns = isCorrectAns;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

}
