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
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.model.Test;
import edu.mum.onlinetest.service.AnswerSheetInterface;
import edu.mum.onlinetest.service.TestServiceInterface;

@Service
public class AnswerSheetServiceImpln implements AnswerSheetInterface {

	@Autowired
	AnswerSheetDao dao;
	@Autowired
	QuestionServiceImpl questionService;
	@Autowired
	TestServiceInterface testService;

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

	public int getResult(AnswerSheet answerSheet2, Long testId) {
		int noOfQuestions = answerSheet2.getAnswerList().size();
		int totalMarks = 0;
		// list of sub categories
		List<String> lists = new ArrayList<>();
		for (int i = 0; i < noOfQuestions; i++) {
			Long quesId = answerSheet2.getAnswerList().get(i).getQuestion().getId();
			Question question = questionService.getQuestionByID(quesId);
			String subcat = question.getSubCategory().getSubCatName();
			if (lists.isEmpty()) {
				lists.add(subcat);
			} else {
				boolean a = true;
				for (int j = 0; j < lists.size(); j++) {
					if (lists.get(j).equals(subcat)) {
						a = false;
						break;
					}
				}
				if (a == true) {
					lists.add(subcat);
				}

			}
		}
		
		
		/*List<SubCategory> lists = new ArrayList<>();
		for (int i = 0; i < noOfQuestions; i++) {
			Long quesId = answerSheet2.getAnswerList().get(i).getQuestion().getId();
			Question question = questionService.getQuestionByID(quesId);
			SubCategory subcat = question.getSubCategory();
			if (lists.isEmpty()) {
				lists.add(subcat);
			} else {
				boolean a = true;
				for (int j = 0; j < lists.size(); j++) {
					if (lists.get(j).equals(subcat)) {
						a = false;
						break;
					}
				}
				if (a == true) {
					lists.add(subcat);
				}

			}
		}*/
		//checking till here
		System.out.println("---------------------" + lists.size());
		List<Integer> individualMark = new ArrayList<>();

		// noOfSubCategory = 4 ;
		for (int i = 0; i < lists.size(); i++) {
			individualMark.add(0);
		}

		for (int i = 0; i < noOfQuestions; i++) {
			System.out.println("******************************** inside service 4");
			Long quesId = answerSheet2.getAnswerList().get(i).getQuestion().getId();
			Question question = questionService.getQuestionByID(quesId);
			int noOfOptions = question.getOpts().size();
			System.out.println(" Size of options : "+noOfOptions);
			for (int j = 0; j < noOfOptions; j++) {
				//Long id = answerSheet2.getAnswerList().get(i).getQuestion().getId();
				//System.out.println(id);
				//Question question = questionService.getQuestionByID(id);
				//System.out.println(question.getOpts().size());
				//System.out.println(question.getOpts().get(j));

				//System.out.println("******************************** inside service 5");

				if (question.getOpts().get(j).getIsCorrectAns() == true) {
					System.out.println("******************************** inside service 6 ******************");
					System.out.println(answerSheet2.getAnswerList().get(i).getSelectedOpt().getId());
					System.out.println(question.getOpts().get(j).getId());
					System.out.println("***********************************************************");

					if (answerSheet2.getAnswerList().get(i).getSelectedOpt().getId()
							.equals(question.getOpts().get(j).getId())) {
						System.out.println("******************************** inside service 7");

						totalMarks += 1;
						System.out.println("size of lists : "+lists.size());
						
						individualMark = calculateIndividualMarks(question, lists, individualMark);
						
						
						/*for (int k = 0; k < lists.size(); i++) {
							if (question.getSubCategory()
									.getSubCatName().equals(lists.get(k))){
								System.out.println("Helooooooooooooooo");
								//individualMark.set(k, individualMark.get(k) + 1);
							}
						}*/
					}
				}
			}

		}
		// Saving subcategory with their marks in map
		Map<String, Integer> eachCategoryMarks = new HashMap<>();
		for (int i = 0; i < individualMark.size(); i++) {
			eachCategoryMarks.put(lists.get(i), individualMark.get(i));
			System.out.println(lists.get(i) + "sub category" + individualMark.get(i));
		}
		
		Test test = testService.getTestById(testId);
		test.setIndividualMark(eachCategoryMarks);
		testService.saveTest(test);
		
		
		/*Map<Integer, SubCategory> eachCategoryMarks = new HashMap<>();
		for (int i = 0; i < individualMark.size(); i++) {
			eachCategoryMarks.put(individualMark.get(i), lists.get(i) );
			System.out.println("Hash Code : "+lists.get(i));
			System.out.println(lists.get(i) + "sub category" + individualMark.get(i));
		}*/

		return totalMarks;

	}

	private List<Integer> calculateIndividualMarks(Question question, List<String> lists, List<Integer> individualMark) {
		// TODO Auto-generated method stub
		/*List<Integer> individualMark = new ArrayList<>();

		// noOfSubCategory = 4 ;
		for (int i = 0; i < lists.size(); i++) {
			individualMark.add(0);
		}*/
		for(int i = 0; i< lists.size(); i++){
			if(question.getSubCategory().getSubCatName().equals(lists.get(i))){
				System.out.println("sub cat marks .............");
				individualMark.set(i, individualMark.get(i) + 1);
			}
		}
		return individualMark;
	}
	/*private List<Integer> calculateIndividualMarks(Question question, List<SubCategory> lists, List<Integer> individualMark) {
		// TODO Auto-generated method stub
		List<Integer> individualMark = new ArrayList<>();

		// noOfSubCategory = 4 ;
		for (int i = 0; i < lists.size(); i++) {
			individualMark.add(0);
		}
		for(int i = 0; i< lists.size(); i++){
			if(question.getSubCategory().equals(lists.get(i))){
				System.out.println("sub cat marks .............");
				individualMark.set(i, individualMark.get(i) + 1);
			}
		}
		return individualMark;
	}*/

}
