package edu.mum.onlinetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.onlinetest.model.AnswerSheet;
import edu.mum.onlinetest.serviceImpl.TestServiceImpl;

@Controller
@RequestMapping("test")
public class TestController {

	@Autowired
	TestServiceImpl testService;

	@RequestMapping(value = "/result/{testId}", method = RequestMethod.POST)
	public String resultTest(AnswerSheet answerSheet, @PathVariable("testId") Long testId) {
		testService.getResult(answerSheet, testId);
		// forward total marks so that student can see it after completing exam
		// on click submit
		return "redirect:/test/answersheet";
	}
}
