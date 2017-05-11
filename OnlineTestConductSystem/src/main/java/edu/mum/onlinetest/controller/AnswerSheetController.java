package edu.mum.onlinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.onlinetest.model.Answer;
import edu.mum.onlinetest.model.AnswerSheet;

@Controller
@RequestMapping(value = "answer")
public class AnswerSheetController {

	/*
	 * @Autowired AnswerSheetServiceImpl answerSheetService;
	 */

	@RequestMapping(value = "/testPaper", method = RequestMethod.GET)
	public String ShowTestPater() {
		return "testPaper";
	}

	/*
	 * @RequestMapping(value = "/result/{testId}", method = RequestMethod.POST)
	 * public String result(List<Integer> answers, @PathVariable("testId") Long
	 * testId) { System.out.println("*********inside result*************"); int
	 * totalmarks = answerSheetService.getResult(answers, testId); //forward
	 * total marks so that student can see it after completing exam on click
	 * submit return "redirect:/test/answersheet"; }
	 */

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String resultTest(@ModelAttribute(".......") AnswerSheet answerSheet) {
		System.out.println("*********inside resultTest*************");
		/* answerSheetService.getResult1(answerSheet); */
		// forward total marks so that student can see it after completing exam
		// on click submit
		return "redirect:/test/answersheet";
	}

	/*
	 * @RequestMapping(value = "/result1", method = RequestMethod.POST) public
	 * String resultTest1(HashMap(Integer,
	 * System.out.println("*********inside resultTest*************");
	 * answerSheetService.getResult1(answerSheet); //forward total marks so that
	 * student can see it after completing exam on click submit return
	 * "redirect:/test/answersheet"; }
	 */

}
