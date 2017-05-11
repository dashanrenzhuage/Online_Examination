package edu.mum.onlinetest.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.AnswerSheetDao;
import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.service.AnswerSheetInterface;

@Service
public class AnswerSheetServiceImpln implements AnswerSheetInterface {

	@Autowired
	AnswerSheetDao dao;
	@Autowired
	QuestionServiceImpl questionService;

	@Override
	public List<AnswerSheet> getAllAnswerSheet() {
		return (List<AnswerSheet>) dao.findAll();
	}

	@Override
	public AnswerSheet getAnswerSheetByID(Long id) {

		return dao.findOne(id);
	}

	@Override
	public void saveAnswerSheet(AnswerSheet answerSheet) {
		dao.save(answerSheet);

	}

	@Override
	public void deleteAnswerSheetByID(Long id) {
		dao.delete(id);

	}

	public int getResult(AnswerSheet answerSheet2) {
		
		System.out.println("******************************** inside service 1");
		
		int noOfQuestions = answerSheet2.getAnswerList().size();
		int totalMarks = 0;
		System.out.println("******************************** inside service 2");

		List<String> lists = new ArrayList<>();
		List<Integer> individualMark = new ArrayList<>();

		// noOfSubCategory = 4 ;
		for (int i = 0; i < 4; i++) {
			individualMark.add(0);

		}
		System.out.println("******************************** inside service 3");


		for (int i = 0; i < noOfQuestions; i++) {
			System.out.println("******************************** inside service 4");

			for (int j = 0; j < 4; j++) {
				Long id = answerSheet2.getAnswerList().get(i).getQuestion().getId();
				System.out.println(id);
				Question question = questionService.getQuestionByID(id);
				System.out.println(question.getOpts().size());
				System.out.println(question.getOpts().get(j));
				
				System.out.println("******************************** inside service 5");
				
				
				
				if (question.getOpts().get(j).getIsCorrectAns() == true) {
					System.out.println("******************************** inside service 6");

					if (answerSheet2.getAnswerList().get(i).getSelectedOpt().getId() == question.getOpts().get(j).getId()) {
						System.out.println("******************************** inside service 7");

						totalMarks += 1;
						/*for (int k = 0; k < 4; i++) {
							if (answerSheet2.getAnswerList().get(i).getQuestion().getSubCategory()
									.getSubCatName() == lists.get(k)) {
								individualMark.set(k, individualMark.get(k) + 1);
							}
						}*/
					}
				}
			}

		}
		// Saving subcategory with their marks in map
					/*Map<String, Integer> eachCategoryMarks = new HashMap<>();
					for (int i = 0; i < individualMark.size(); i++) {
						eachCategoryMarks.put(lists.get(i), individualMark.get(i));
					}*/

					return totalMarks;

	}
	
}
