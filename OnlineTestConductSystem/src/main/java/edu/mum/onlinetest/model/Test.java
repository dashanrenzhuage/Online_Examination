package edu.mum.onlinetest.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Test {
	@javax.persistence.Id
	@GeneratedValue
	private Long id;
	
	private String category;
	
	@OneToOne
	private Student student;
	@OneToOne
	private AnswerSheet answerSheet;
	
	private int totalmarks;
	
	@ElementCollection
    @MapKeyColumn(name="name")
    Map<String, Integer> individualMark = new HashMap<String, Integer>();

	
	
	public Map<String, Integer> getIndividualMark() {
		return individualMark;
	}
	public void setIndividualMark(Map<String, Integer> individualMark) {
		this.individualMark = individualMark;
	}
	public AnswerSheet getAnswerSheet() {
		return answerSheet;
	}
	public void setAnswerSheet(AnswerSheet answerSheet) {
		this.answerSheet = answerSheet;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	/*@OneToMany
	private List<Question>questionList;*/
	
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	/*public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}*/
	/*public AnswerSheet getAnswersheet() {
		return answersheet;
	}
	public void setAnswersheet(AnswerSheet answersheet) {
		this.answersheet = answersheet;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	/*public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}*/
	public int getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", student=" + student + ", answerSheet=" + answerSheet + ", totalmarks=" + totalmarks
				+ "]";
	}
	
	
	
	

}
