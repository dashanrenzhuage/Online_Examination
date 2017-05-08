package edu.mum.onlinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.onlinetest.model.Answer;
import edu.mum.onlinetest.serviceImpl.AnswerSheetServiceImpl;

@Controller
@RequestMapping(value = "answer")
public class AnswerSheetController {
	
	@Autowired
	AnswerSheetServiceImpl answerSheetService;
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(List<Integer> answers, Long testId) {
		int totalmarks = answerSheetService.getResult(answers, testId);
		return "redirect:/test/answersheet";
	}

}
