package edu.mum.onlinetest.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.service.CategoryServiceInterface;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionServiceInterface questionService;
	
	@Autowired 
	CategoryServiceInterface categoryService;

	@Autowired
	SubCategoryInterface subCatService;


	@RequestMapping(method = RequestMethod.GET)
	public String getAllQuestion(Model model){
		
		
		model.addAttribute("questions", questionService.getAllQuestion());
		
		return "questions";
		

		
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addQuestion(@ModelAttribute("newQuestion") Question question, Model model){
		
		model.addAttribute("categories",categoryService.getAllCategory());
		subCatService.getAllSubCategory().forEach(sb->{
			System.out.println("_______________"+sb.getCategory().getName());
		});
		model.addAttribute("subCategories",subCatService.getAllSubCategory());
		return "addQuestion";
		
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String questionAdded(@ModelAttribute("newQuestion") Question question  ){
		
		/*if(result.hasErrors()){
			return "addQuestion";
		}
		*/
		questionService.saveQuestion(question);
		return "Homepage";
	}

}
