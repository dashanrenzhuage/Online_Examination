package edu.mum.onlinetest.service;

import java.util.List;

import edu.mum.onlinetest.model.Grading;

public interface GradingServiceInterface {
	public List<Grading>getAllGrading(); 
	public Grading getGradingByID(Long id);
	public void saveGrading(Grading grading);
	public void deletegradingByID(Long id);
}
