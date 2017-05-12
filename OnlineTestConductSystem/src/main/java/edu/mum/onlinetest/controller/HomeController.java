package edu.mum.onlinetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.onlinetest.model.Category;
import edu.mum.onlinetest.serviceImpl.CategoryServiceImpl;

@Controller
public class HomeController {

	@Autowired
	CategoryServiceImpl categoryService;

	@RequestMapping("/")
	public String login() {

		return "login";
	}
	
	@RequestMapping("/exam/finish")
	public String examFinishPage() {

		return "exam_finish_page";
	}

}