package edu.mum.onlinetest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.service.CategoryServiceInterface;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;

@Controller
@RequestMapping("/question")
public class QuestionUploadController {

	@Autowired
	QuestionServiceInterface questionService;

	@Autowired
	SubCategoryInterface subcategoryService;

	


	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@ModelAttribute("subcategory") SubCategory subcategory, HttpServletRequest request ) {
		String fileName = request.getParameter("fileName");
		System.out.println(fileName);
		questionService.saveALLQuestion(questionService.uploadQuestion(subcategory.getId(),fileName));
		return "redirect:/dataAdmin/uploadFile";
	}
	

	@RequestMapping(value = "/generateTTSS", method= RequestMethod.POST)
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
