package edu.mum.onlinetest.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.TestDao;
import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.model.Result;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.model.SubCategoryGrade;
import edu.mum.onlinetest.model.Test;
import edu.mum.onlinetest.service.TestServiceInterface;

@Service
public class TestServiceImpl implements TestServiceInterface {

	@Autowired
	TestDao dao;

	/*
	 * @Autowired Test test;
	 */
	/*
	 * @Autowired Result result;
	 */
	/*
	 * @Autowired SubCategoryGrade subCategoryGrade;
	 */

	@Override
	public List<Test> getAllTest() {
		List<Test> tests = (List<Test>) dao.findAll();
		return tests;
	}

	@Override
	public Test getTestById(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void saveTest(Test test) {
		dao.save(test);
	}

	@Override
	public void deleteTestById(Long id) {
		dao.delete(id);
	}

	public void getResult(AnswerSheet answerSheet, Long testId) {
		/*
		 * int noOfQuestions = answerSheet.getAnswerList().size(); int
		 * noOfSubcategories = test.getSubCategories().size();
		 * 
		 * int totalMarks = 0;
		 * 
		 * List<SubCategory> lists = new ArrayList<>();
		 * lists.addAll(test.getSubCategories());
		 * 
		 * // add those subcategories to list whose questions are generated
		 * 
		 * List<Integer> individualMark = new ArrayList<>(); noOfSubCategory = 4
		 * for (int i = 0; i < 4; i++) { individualMark.add(0);
		 * 
		 * }
		 * 
		 * for (int i = 0; i < noOfQuestions; i++) { for (int j = 0; j < 4; j++)
		 * { if
		 * (answerSheet.getAnswerList().get(i).getQuestion().getOpts().get(j).
		 * isCorrect() == true) { if
		 * (answerSheet.getAnswerList().get(i).getAnswer1() == j) { totalMarks
		 * += 1; for (int k = 0; k < 4; i++) { if
		 * (answerSheet.getAnswerList().get(i).getQuestion().getSubCategory()
		 * .getSubCatName() == lists.get(k).getSubCatName()) {
		 * individualMark.set(k, individualMark.get(k) + 1); } } } } }
		 * 
		 * } result.setTotalMarks(totalMarks); List<SubCategoryGrade>
		 * listSubCategoryGrade = new ArrayList<>(); for (int i = 0; i <
		 * noOfSubcategories; i++) {
		 * subCategoryGrade.setSubCategory(lists.get(i));
		 * subCategoryGrade.setTotalMarks(individualMark.get(i));
		 * listSubCategoryGrade.add(subCategoryGrade); }
		 * result.setSubCategoryGrades(listSubCategoryGrade);
		 */
	}

	@Override
	public List<Test> getALlbyStudentId(Long id) {
		
		return (List<Test>)dao.findByStudentId(id);
	}
	
	
	

}
