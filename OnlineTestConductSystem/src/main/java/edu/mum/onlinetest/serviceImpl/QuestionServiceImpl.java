package edu.mum.onlinetest.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.dao.QuestionDao;
import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.Opts;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.parser.XLSXParser;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;

@Service
public class QuestionServiceImpl implements QuestionServiceInterface {

	@Autowired
	QuestionDao dao;

	@Autowired
	SubCategoryInterface subcategoryService;

	@Override
	public List<Question> getAllQuestion() {
		List<Question> questions = (List<Question>) dao.findAll();
		/*
		 * for (Question question : questions) { Logger.getLogger(
		 * "Question contains subcategory:" +
		 * question.getSubCategory().getCategory()); }
		 */
		return questions;

		/*
		 * List<SubCategory> subCategories = (List<SubCategory>) dao.findAll();
		 * for(SubCategory subCategory: subCategories){ Logger.getLogger(
		 * "Category contains subcategories size:"
		 * +subCategory.getQuestions().size()); } return subCategories;
		 */

	}

	@Override
	public Question getQuestionByID(Long id) {
		return dao.findOne(id);
	}

	@Override
	public void deleteQuestionByID(Long id) {
		dao.delete(id);

	}

	@Override
	public void saveQuestion(Question question) {
		dao.save(question);

	}

	@Override
	public void saveALLQuestion(List<Question> allQuestion) {
		dao.save(allQuestion);

	}

	@Override
	public List<Question> findBySubCategoryName(String subCatName) {
		return dao.findBySubCategoryName(subCatName);
	}

	@Override
	public List<Long> findIdByName(String name) {
		return dao.findIdByName(name);
	}

	@Override
	public List<Question> getRandomQuestion(List<SubCategory> subCatList) {
		List<Question> questionList = new ArrayList<>();
		// List<SubCategory> subCatList = category.getSubcategories();
		for (SubCategory subCategory : subCatList) {
			System.out.println("subCategory: " + subCategory.getSubCatName());
			List<Long> quesIds = dao.findIdByName(subCategory.getSubCatName());

			for (Long id : quesIds) {
				System.out.println("questionId: " + id);

			}
			Collections.shuffle(quesIds);
			List<Long> newIds = new ArrayList<>();
			if (quesIds.size() >= 3) {
				for (int i = 0; i < 3; i++) {
					newIds.add(quesIds.get(i));
				}
				quesIds.clear();
				quesIds.addAll(newIds);
			}

			questionList.addAll((List<Question>) dao.findAll(quesIds));
			questionList.forEach(qL -> {
				System.out.println(qL.getQuesName());
			});
		}
		return questionList;

	}

	@Override
	public List<Question> uploadQuestion() {
		List<Question> allQuestList = new ArrayList<>();
		XLSXParser parser = new XLSXParser();
		List<List<String>> quesList = parser.getQuestions();
		for (List<String> singleQuesList : quesList) {

			int correctIndex = getAnswerIndex(singleQuesList);

			Question question = new Question();
			List<Opts> options = new ArrayList<>();

			for (int i = 0; i < singleQuesList.size() - 1; i++) {
				Opts option = new Opts();

				if (i == 0) {
					question.setQuesName(singleQuesList.get(i));
				} else {

					option.setOptions(singleQuesList.get(i));

					if (correctIndex == i) {
						option.setCorrectAns(true);
					}
					options.add(option);
				}
			}
			question.setOpts(options);
			question.setSubCategory(subcategoryService.getSubCategoryByID((long) 80));
			if (question.getQuesName() != null) {
				allQuestList.add(question);
			}

		}

		return allQuestList;

	}

	public int getAnswerIndex(List<String> list) {
		try {
			if (!list.isEmpty()) {
				String answer = list.get(list.size() - 1);
				System.out.println("Answer: " + answer);
				if ("A".equalsIgnoreCase(answer)) {
					return 1;
				}
				if ("B".equalsIgnoreCase(answer)) {
					return 2;
				}
				if ("C".equalsIgnoreCase(answer)) {
					return 3;
				}
				if ("D".equalsIgnoreCase(answer)) {
					return 4;
				}
				if ("E".equalsIgnoreCase(answer)) {
					return 5;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("===========================================" + e);
		}

		return 0;
	}

}
