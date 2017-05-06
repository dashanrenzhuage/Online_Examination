package edu.mum.onlinetest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.Employee;
import edu.mum.onlinetest.model.Opts;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.parser.XLSXParser;
import edu.mum.onlinetest.service.CategoryServiceInterface;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionServiceInterface questionService;

	@Autowired
	SubCategoryInterface subCatService;
	
	@Autowired
	CategoryServiceInterface categoryService;

/*	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Question question, UriComponentsBuilder ucBuilder) {
		questionService.saveQuestion(question);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Question>> getAll() {
		
//		List<Question> questions = questionService.getAllQuestion();
		List <Long> cp = questionService.findIdByName("spring");
		cp.forEach(c->{
			System.out.println(c);
		});
		List<Question> questions = questionService.findBySubCategoryName("spring");
	
		for(Question q: questions){
			
			System.out.println("............................"+q.getQuesName());
//			System.out.println("............................"+q.getSubCategory());
//			System.out.println("............................"+q.getOpts().size());
		}
		 

		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
		
		
	}
	
	

	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public void generateQuestions(@RequestParam("category") Long categoryid,  HttpServletRequest request) {
		System.out.println("i m here--------------");
		//List<Question> quesList= questionService.getRandomQuestion();
		Category category = categoryService.getCategoryByID(categoryid);
		String[] listOfString = request.getParameterValues("subCategory");
		
		List<SubCategory> listOfSubCategory = new ArrayList<>();
		for(int i=0; i<listOfString.length; i++){
			SubCategory subCat = subCatService.getSubCategoryByID(Long.parseLong(listOfString[i]));
			listOfSubCategory.add(subCat);
		}
		/*for(SubCategory c: listOfSubCategory){
			System.out.println(c.getSubCatName());
		}*/
		//List<Question> quesList= questionService.getRandomQuestion();
		
	}


}
