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
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.QuestionServiceInterface;

@Service
public class QuestionServiceImpl implements QuestionServiceInterface {

	@Autowired
	QuestionDao dao;

	@Override
	public List<Question> getAllQuestion() {
		List<Question> questions = (List<Question>) dao.findAll();
		/*for (Question question : questions) {
			Logger.getLogger("Question contains subcategory:" + question.getSubCategory().getCategory());
		}*/
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
		
		//List<Long> quesIds = new ArrayList<Long>();
//		List<SubCategory> subCatList = category.getSubcategories();
		for (SubCategory subCategory : subCatList) {
			//System.out.println("subCategory: " + subCategory.getSubCatName());
			System.out.println("SubCategory: " + subCategory.getSubCatName());
			List<Long> quesIds1 = new ArrayList<>();
			List<Long> allQuestionIds = new ArrayList<>();
			quesIds1 = dao.findIdByName(subCategory.getSubCatName());
			

			for (Long id : quesIds1) {
				System.out.println("questionId: " + id);

			}
			Collections.shuffle(quesIds1);
			List<Long> newIds = new ArrayList<Long>();
			if (quesIds1.size() >= 1) {
				for (int i = 0; i < 3; i++) {
					newIds.add(quesIds1.get(i));
				}
				//quesIds.clear();
				allQuestionIds.addAll(newIds);
			}

			questionList.addAll((List<Question>) dao.findAll(allQuestionIds));
			/*questionList.forEach(qL -> {
				System.out.println(qL.getQuesName());
			});*/
		}
		return questionList;
		
	}
	

}
