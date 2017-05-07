package edu.mum.onlinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;

@Controller
@RequestMapping("/question")
public class QuestionUploadController {

	@Autowired
	QuestionServiceInterface questionService;

	@Autowired
	SubCategoryInterface subcategoryService;


	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public void upload() {
		
//			question.setSubCategory(subcategoryService.getSubCategoryByID((long) 114));

		
		questionService.saveALLQuestion(questionService.uploadQuestion());
	}
	
	@RequestMapping(value = "/generates", method= RequestMethod.GET)
	public void questionGenerate(@ ModelAttribute ("category") Category category,BindingResult result){
//		List<SubCategory> subCatList = category.getSubcategories();
//		for(SubCategory subCategory: subCatList){
			
			List<Long> quesId = questionService.findIdByName("spring");
			for(Long id: quesId){
				System.out.println("questionId: "+ id);
//			}
		}
		
	}
}
