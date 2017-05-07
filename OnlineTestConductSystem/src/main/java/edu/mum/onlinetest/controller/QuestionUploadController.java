package edu.mum.onlinetest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.Opts;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.parser.XLSXParser;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;

@RestController
@RequestMapping("/question")
public class QuestionUploadController {

	@Autowired
	QuestionServiceInterface questionService;

	@Autowired
	SubCategoryInterface subcategoryService;
	

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public void upload() {

		XLSXParser parser = new XLSXParser();
		List<List<String>> quesList = parser.getQuestion();
		for (List<String> singleQuesList : quesList) {
			Question question = new Question();
			List<Opts> options = new ArrayList<>();

			for (int i = 0; i < singleQuesList.size(); i++) {
				Opts option = new Opts();

				if (i == 0) {
					question.setQuesName(singleQuesList.get(i));
				} else {
					option.setOptions(singleQuesList.get(i));
					options.add(option);
				}
			}
			question.setOpts(options);

			question.setSubCategory(subcategoryService.getSubCategoryByID((long) 3));

			questionService.saveQuestion(question);
		}
	}
	
	@RequestMapping(value = "/generatesss", method= RequestMethod.POST)
	public void questionGenerate(@ModelAttribute ("category") Category category,BindingResult result){
//		List<SubCategory> subCatList = category.getSubcategories();
//		for(SubCategory subCategory: subCatList){
			
			List<Long> quesId = questionService.findIdByName("spring");
			for(Long id: quesId){
				System.out.println("questionId: "+ id);
//			}
		}
		
	}
}
