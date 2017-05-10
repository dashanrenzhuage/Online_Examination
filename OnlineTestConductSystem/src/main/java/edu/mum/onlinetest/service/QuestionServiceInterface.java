package edu.mum.onlinetest.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.SubCategory;

public interface QuestionServiceInterface {

	public List<Question>getAllQuestion(); 
	public Question getQuestionByID(Long id);
	public void saveQuestion(Question question);
	public void saveALLQuestion(List<Question> allQuestion);
	public void deleteQuestionByID(Long id);
	public List<Question> findBySubCategoryName(String subCatName);
	public List<Long> findIdByName(@Param("name") String name);
	public List<Question> getRandomQuestion(List<SubCategory> subCategories);
	public List<Question> uploadQuestion(Long subCatId, String fileName);
}
