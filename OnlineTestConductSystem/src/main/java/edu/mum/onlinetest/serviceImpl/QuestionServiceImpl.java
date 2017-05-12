package edu.mum.onlinetest.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.onlinetest.dao.QuestionDao;
import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.FileUpload;
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
		if (!question.getOpts().isEmpty()) {
			Iterator<Opts> itr = question.getOpts().iterator();
			while (itr.hasNext()) {
				if (itr.next().getOptions().isEmpty()) {
					itr.remove();
				}

			}}
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
		if (!subCatList.isEmpty()) {
			for (SubCategory subCategory : subCatList) {
				System.out.println("subCategory: " + subCategory.getSubCatName());
				List<Long> quesIds = dao.findIdByName(subCategory.getSubCatName());

				for (Long id : quesIds) {
					System.out.println("questionId: " + id);

				}
				Collections.shuffle(quesIds);
				List<Long> newIds = new ArrayList<>();
				if (quesIds.size() >= 10) {
					for (int i = 0; i < 10; i++) {
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
		}
		return questionList;

	}

	@Override
	public List<Question> uploadQuestion(Long subCatId, String fileName) {
		List<Question> allQuestList = new ArrayList<>();
		XLSXParser parser = new XLSXParser();
		List<List<String>> quesList = parser.getQuestions(fileName);
		if (!quesList.isEmpty()) {
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
							option.setIsCorrectAns(true);
						}
						options.add(option);
					}
				}
				question.setOpts(options);
				question.setSubCategory(subcategoryService.getSubCategoryByID(subCatId));
				if (question.getQuesName() != null) {
					allQuestList.add(question);
				}

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

	@Override
	public boolean checkDuplicateOpts(List<Opts> listOpts) {
		for (int i = 0; i < listOpts.size(); i++) {

			for (int j = 0; j < listOpts.size(); j++) {
				if (i != j) {
					if (listOpts.get(i).getOptions().equalsIgnoreCase((listOpts.get(j).getOptions()))) {
						return true;
					}
				}
			}
		}
		return false;
	
	}

	@Override
	public String getUploadedFileName(FileUpload questionFile) {

		String uploadPath = System.getProperty("catalina.home") + File.separator + "onlinetestconductsystem"
				+ File.separator + "questions" + File.separator;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		// start here
		MultipartFile file = questionFile.getUploadFile();

		// isEmpty means file exists BUT NO Content
		String fileName = null;
		if (file != null && !file.isEmpty()) {
			try {
				fileName = questionFile.getUploadFile().getOriginalFilename();
				String filePath = uploadPath + File.separator + fileName;
				System.out.println("Path of file:" + filePath);
				File storeFile = new File(filePath);
				file.transferTo(storeFile);
			} catch (Exception e) {
				throw new RuntimeException("File uploading failed", e);
			}
		}
		return fileName;
	}

}
