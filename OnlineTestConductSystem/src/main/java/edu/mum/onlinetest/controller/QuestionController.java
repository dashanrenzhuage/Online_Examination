package edu.mum.onlinetest.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.onlinetest.model.Answer;
import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.model.Opts;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.Student;
import edu.mum.onlinetest.service.AnswerServiceInterface;
import edu.mum.onlinetest.service.AnswerSheetInterface;
/*import edu.mum.onlinetest.parser.XLSXParser;
*/import edu.mum.onlinetest.service.CategoryServiceInterface;

import edu.mum.onlinetest.model.SubCategory;
import edu.mum.onlinetest.model.Test;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.SubCategoryInterface;
import edu.mum.onlinetest.serviceImpl.StudentServiceImpl;
import edu.mum.onlinetest.serviceImpl.TestServiceImpl;

@Controller
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionServiceInterface questionService;

	@Autowired
	SubCategoryInterface subCatService;

	@Autowired
	CategoryServiceInterface categoryService;
	@Autowired
	AnswerServiceInterface answerService;
	@Autowired
	AnswerSheetInterface answerSheetService;
	@Autowired
	SubCategoryInterface subCategoryService;
	@Autowired
	StudentServiceImpl studentService;
	@Autowired
	TestServiceImpl testService;

	/*
	 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<Void>
	 * create(@RequestBody Question question, UriComponentsBuilder ucBuilder) {
	 * questionService.saveQuestion(question); HttpHeaders headers = new
	 * HttpHeaders(); return new ResponseEntity<Void>(headers,
	 * HttpStatus.CREATED); }
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Question>> getAll() {
		List<Question> questions = questionService.getAllQuestion();
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addQuestion(Model model) {
		List<Category> listOfCateogy = categoryService.getAllCategory();
		model.addAttribute("listOfCategory", listOfCateogy);
		Question q = new Question();
		List<Opts> options = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			options.add(new Opts());
		}
		q.setOpts(options);
		model.addAttribute("question", q);
		return "add_question";
	}

	@RequestMapping(value = "/get/subcategories/{id}", method = RequestMethod.GET)
	public @ResponseBody List<SubCategory> getSubCategory(@PathVariable("id") Long id, Model model) {

		return subCatService.getSubCategoriesByCategoryId(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result, Model model,
			RedirectAttributes rm) {
		if (result.hasErrors()) {
			return "add_question";
		} else {
			if (!question.getOpts().isEmpty()) {
				Iterator<Opts> itr = question.getOpts().iterator();
				while (itr.hasNext()) {
					if (itr.next().getOptions().isEmpty()) {
						itr.remove();
					}

				}

				if (questionService.checkDuplicateOpts(question.getOpts())) {
					rm.addFlashAttribute("message",
							"You have entered duplicate options. Please provide unique options.");
					return "redirect:/question/add";
				}
				if (question.getOpts().size() <= 1) {
					rm.addFlashAttribute("message", "Enter more than one option.");
					return "redirect:/question/add";
				}
			}

			questionService.saveQuestion(question);
			rm.addFlashAttribute("message", "Question successfully added");

		}
		return "redirect:/question/add";

	}

	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public String generateQuestions(@RequestParam("category") Long categoryid, HttpServletRequest request,
			@ModelAttribute("newAnswer") AnswerSheet newAnswer, Model model, HttpSession session) {
		System.out.println("i m here--------------");

		Category category = categoryService.getCategoryByID(categoryid);
		String[] listOfString = request.getParameterValues("subCategory");
		/*if (listOfString.length == 3 || listOfString.length == 4) {*/
			List<SubCategory> listOfSubCategory = new ArrayList<>();
			for(int i=0; i<listOfString.length; i++){
				SubCategory subCat = subCatService.getSubCategoryByID(Long.parseLong(listOfString[i]));
				listOfSubCategory.add(subCat);
			}
			Answer answer= new Answer();
			List<Question> questionList= questionService.getRandomQuestion(listOfSubCategory);
			
			Test test = new Test();
			Long id =  Long.parseLong((String) request.getSession().getAttribute("studentId")); 
			
			Student student = studentService.getStudentByID( id);
			test.setStudent(student);
			test.setCategory(category.getName());
			testService.saveTest(test);
			List<Answer> answers = new ArrayList<>();
			for(int i=0; i<questionList.size(); i++){
				answer.setQuestion(questionList.get(i));
				answers.add(answer);
			}
			model.addAttribute("sizeQuestion",(Integer)questionList.size()-1);
			model.addAttribute("questionsList", questionList);
			model.addAttribute("answers", answers);
			model.addAttribute("testId", test.getId().toString());

			questionList.forEach(ql -> {
				ql.getOpts().forEach(op -> {
					System.out.println(op.getOptions());
				});

			});
			request.setAttribute("genarateQuestionList", questionList);
			return "questionpaper";

		/*}

		else {
			List<Category> listOfCategories = categoryService.getAllCategory();
			List<SubCategory> listOfSubCategories = subCategoryService.getAllSubCategory();
			model.addAttribute("listOfCategories", listOfCategories);
			model.addAttribute("listOfSubcategories", listOfSubCategories);
			model.addAttribute("message", "Please choose sub-category number between 3 or 4");
			return "stu_sel_exam";
		}*/

		/* return "giveExam"; */
		/* return "click_to_start_exam"; */
	}

	

	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public String addAnswer(@ModelAttribute("newAnswer") AnswerSheet newAnswer, Model model, HttpServletRequest request,
			HttpSession session) {
		List<Question> questionList = new ArrayList<>();
		List<Answer> answerList = newAnswer.getAnswerList();
		for (int i = 0; i < answerList.size(); i++) {
			// answerList.get(i).setQuestion(questionList.get(i));
			answerService.saveAnswer(answerList.get(i));
		}
		answerSheetService.saveAnswerSheet(newAnswer);
		String s = (String) session.getAttribute("testId");
		Long id = Long.parseLong(s);
		
		int marks = answerSheetService.getResult(newAnswer, id);
		
		AnswerSheet newAnswerSheet = answerSheetService.getAnswerSheetByID(newAnswer.getId());
		 Test test1 = testService.getTestById(id);
		 test1.setAnswerSheet(newAnswerSheet);
		 test1.setTotalmarks(marks);
		 testService.saveTest(test1);
		
		model.addAttribute(newAnswer);
		model.addAttribute("marks", test1.getTotalmarks());
		return "studentAfterSubmitExam";

	}

	@RequestMapping(value = "/clicktostartexam", method = RequestMethod.POST)
	public String showStartExam() {

		System.out.println("****************************** inside question/clicktoshowstartexam POST");
		return "click_to_start_exam";
	}

	@RequestMapping(value = "/generate1", method = RequestMethod.POST)
	public ResponseEntity<List<Question>> generateQuestions(HttpServletRequest request,
			@RequestBody Category category) {

		System.out.println("****************************** inside question/generate post");

		List<SubCategory> subCategories = category.getSubcategories();
		List<Question> quesList = questionService.getRandomQuestion(subCategories);
		return new ResponseEntity<List<Question>>(quesList, HttpStatus.OK);

		

	}

}