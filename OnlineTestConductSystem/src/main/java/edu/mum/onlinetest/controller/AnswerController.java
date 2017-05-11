package edu.mum.onlinetest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.onlinetest.model.Answer;
import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.model.Opts;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.AnswerServiceInterface;
import edu.mum.onlinetest.service.AnswerSheetInterface;

@Controller
@RequestMapping("question/testQuestion")
public class AnswerController {

	@Autowired
	AnswerServiceInterface answerService;

	@Autowired
	AnswerSheetInterface answerSheetService;

	@Autowired
	QuestionServiceInterface questionService;

	@RequestMapping(method = RequestMethod.GET)
	public String getTest(@ModelAttribute("newAnswer") AnswerSheet newAnswer, Model model) {
	
		
		
	
		List<Question> questionList = new ArrayList<>();
		Answer answer= new Answer();
		questionList = questionService.getAllQuestion();
		List<Answer> answers = new ArrayList<>();
		for(int i=0; i<questionList.size(); i++){
			answer.setQuestion(questionList.get(i));
			answers.add(answer);
		}
		model.addAttribute("questionsList", questionService.getAllQuestion());
		model.addAttribute("answers", answers);
		return "questionpaper";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addAnswer(@ModelAttribute("newAnswer1") AnswerSheet newAnswer, Model model) {

		
		List<Question> questionList = new ArrayList<>();
		questionList = questionService.getAllQuestion();
		List<Answer> answerList = newAnswer.getAnswerList();
		for(int i =0; i<answerList.size(); i++){
			answerList.get(i).setQuestion(questionList.get(i));
			answerService.saveAnswer(answerList.get(i));
		}

		newAnswer.setMarks(answerSheetService.getResult(newAnswer));
		answerSheetService.saveAnswerSheet(newAnswer);
		System.out.println("*******************Result*******************");
		System.out.println("*******************Result*******************");
		
		System.out.println(answerSheetService.getResult(newAnswer));
		
		System.out.println("*******************Result*******************");
		System.out.println("*******************Result*******************");
		return "homepage";

	}
	 

	/*@RequestMapping(method = RequestMethod.GET)
	public String getTest(@ModelAttribute("newAnswer") Answer newAnswer, Model model) {

		Opts opt = new Opts();
		opt.setCorrectAns(true);
		opt.setOptions("TRUE");
		Opts opt1 = new Opts();
		opt.setOptions("FALSE");
		Opts opt2 = new Opts();

		opt.setOptions("NONE");
		Opts opt3 = new Opts();

		opt.setOptions("T/F");
		List<Opts> optList = new ArrayList<>();
		optList.add(opt);
		optList.add(opt1);
		optList.add(opt2);
		optList.add(opt3);

		Question quest = new Question();
		quest.setQuesName("JAVA is more secure program.");
		quest.setOpts(optList);
		questionService.saveQuestion(quest);

		model.addAttribute("questionsList", questionService.getAllQuestion());
		List<Opts> option = questionService.getQuestionByID((long) 6).getOpts();
		model.addAttribute("questions", questionService.getQuestionByID((long) 6));
		model.addAttribute("option", option);
		return "questionpaper";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addAnswer(@ModelAttribute("newAnswer") Answer newAnswer, Model model) {
		
		newAnswer.setQuestion(questionService.getQuestionByID((long) 6));
		System.out.println("Selected Option"+ newAnswer.getSelectedOpt().getId());
		answerService.saveAnswer(newAnswer);
		return "homepage";

	}
*/
}
