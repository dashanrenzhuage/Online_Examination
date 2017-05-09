package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Grading {
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	private int scoreTo;
	private int scoreFrom;
	private String grade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getScoreTo() {
		return scoreTo;
	}
	public void setScoreTo(int scoreTo) {
		this.scoreTo = scoreTo;
	}
	public int getScoreFrom() {
		return scoreFrom;
	}
	public void setScoreFrom(int scoreFrom) {
		this.scoreFrom = scoreFrom;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
