package edu.mum.onlinetest.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.SubCategory;

@Service
public class AnswerSheetServiceImpl {

	/*@Autowired
	TestServiceImpl testService;*/
	/*@Autowired
	AnswerSheet answerSheet;*/

	/*public Integer getResult(List<Integer> answers, Long testId) {

		int noOfQuestions = testService.getTestById(testId).getQuestionList().size();
		int noOfSubCategory = testService.getTestById(testId).getSubCategories().size();
		List<SubCategory> lists = testService.getTestById(testId).getSubCategories();
		List<Integer> individualMark = new ArrayList<>();
		for (int i = 0; i < noOfSubCategory; i++) {
			individualMark.add(0);

		}

		List<Question> testQuestions = testService.getTestById(testId).getQuestionList();
		int totalMarks = 0;

		for (int i = 0; i < noOfQuestions; i++) {
			int noOfOptions = testQuestions.get(i).getOpts().size();
			for (int j = 0; j < noOfOptions; j++)
				if (testQuestions.get(i).getOpts().get(j).isCorrect()) {
					if (answers.get(i) == j) {
						totalMarks += 1;
						for (int k = 0; k < noOfSubCategory; i++) {
							if (testQuestions.get(i).getSubCategory() == lists.get(k)) {
								individualMark.set(k, individualMark.get(k) + 1);
								
								 * int ab = individualMark.get(k) + 1;
								 * List<Integer> temp = new ArrayList<>(); for
								 * (int l = 0; l < noOfSubCategory; l++) { if (l
								 * == k) { temp.add(ab); } else {
								 * temp.add(individualMark.get(k)); } }
								 * individualMark.addAll(temp);
								 
							}
						}

					}
				}
		}
		System.out.println(individualMark);
		testService.getTestById(testId).setTotalmarks(totalMarks);
		System.out.println(noOfSubCategory);
		int sum = 0;
		for (int i = 0; i < noOfSubCategory; i++) {
			sum += individualMark.get(i);
			if (sum == totalMarks) {
				System.out.println("***************Success");
			} else {
				System.out.println("****************logic error in marks calculation");
			}
		}

		// Saving subcategory with their marks in map
		Map<String, Integer> eachCategoryMarks = new HashMap<>();
		for (int i = 0; i < individualMark.size(); i++) {
			eachCategoryMarks.put(lists.get(i).getSubCatName().toString(), individualMark.get(i));
		}

		return totalMarks;
	}*/

	public int getResult1(AnswerSheet answerSheet2) {
		int noOfQuestions = answerSheet2.getAnswerList().size();
		int totalMarks = 0;

		List<String> lists = new ArrayList<>();
		
		//add those subcategories to list whose questions are generated

		List<Integer> individualMark = new ArrayList<>();
		/* noOfSubCategory = 4 */
		for (int i = 0; i < 4; i++) {
			individualMark.add(0);

		}

		for (int i = 0; i < noOfQuestions; i++) {
			for (int j = 0; j < 4; j++) {
				if (answerSheet2.getAnswerList().get(i).getQuestion().getOpts().get(j).isCorrect() == true) {
					if (answerSheet2.getAnswerList().get(i).getAnswer1() == j) {
						totalMarks += 1;
						for (int k = 0; k < 4; i++) {
							if (answerSheet2.getAnswerList().get(i).getQuestion().getSubCategory()
									.getSubCatName() == lists.get(k)) {
								individualMark.set(k, individualMark.get(k) + 1);
							}
						}
					}
				}
			}

		}
		// Saving subcategory with their marks in map
					Map<String, Integer> eachCategoryMarks = new HashMap<>();
					for (int i = 0; i < individualMark.size(); i++) {
						eachCategoryMarks.put(lists.get(i), individualMark.get(i));
					}

					return totalMarks;

	}
	
}
