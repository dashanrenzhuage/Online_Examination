package edu.mum.onlinetest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.GradingDao;
import edu.mum.onlinetest.model.Grading;
import edu.mum.onlinetest.service.GradingServiceInterface;
@Service
public class GradingServiceImpl implements GradingServiceInterface {

	@Autowired
	GradingDao dao;

	@Override
	public List<Grading> getAllGrading() {
		List<Grading> gradingList = (List<Grading>) dao.findAll();
		return gradingList;
	}

	@Override
	public Grading getGradingByID(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void saveGrading(Grading grading) {
		dao.save(grading);
	}

	@Override
	public void deletegradingByID(Long id) {
		dao.delete(id);
	}
	
	//Calculate Grade from marks obtained
	
	@Autowired
	AnswerSheetServiceImpl answerSheetService;
	

}
