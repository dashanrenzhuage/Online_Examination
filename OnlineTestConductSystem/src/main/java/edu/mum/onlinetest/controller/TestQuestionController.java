package edu.mum.onlinetest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.onlinetest.model.Opts;
import edu.mum.onlinetest.model.Question;
import edu.mum.onlinetest.model.TestQuestion;
import edu.mum.onlinetest.service.QuestionServiceInterface;
import edu.mum.onlinetest.service.TestQuestionServiceInterface;

@Controller
@RequestMapping("question/testQuestion")
public class TestQuestionController {

	@Autowired
	TestQuestionServiceInterface testService;

	@Autowired
	QuestionServiceInterface questionService;

	@RequestMapping(method = RequestMethod.GET)
	public String addTest(@ModelAttribute("newTestQuestion") TestQuestion testQuestion, Model model) {
		List<Opts> optsList = new ArrayList<Opts>();
		Opts opt = new Opts();
		opt.setOptions("1");
		opt.setIsCorrectAns(true);
		optsList.add(opt);
		Opts opt1 = new Opts();
		opt.setOptions("2");
		optsList.add(opt1);
		Opts opt2 = new Opts();
		opt.setOptions("3");
		optsList.add(opt2);
		optsList.forEach(op -> {
			System.out.println(op);
		});
		Question qs = new Question();
		qs.setQuesName("How many iteration in JAVA?");
		qs.setOpts(optsList);
		questionService.saveQuestion(qs);
		model.addAttribute("question", qs);
		model.addAttribute("optsList", optsList);
		return "examPaper";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addedTest(@ModelAttribute("newTestQuestion") TestQuestion testQuestion, Model model) {
		System.out.println(testQuestion.getId() + "............" + testQuestion.getQuestion());
		System.out.println(testQuestion.getSlectedOption());

		testService.saveTestQuestion(testQuestion);
	}

}
