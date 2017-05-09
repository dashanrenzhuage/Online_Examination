package edu.mum.onlinetest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ModelAttribute;
=======
>>>>>>> b7f5e7080d9066250e5b999d36f7bfa30f5fac2c
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
	public String login(){
		
		return "login";
	}
	/*@RequestMapping(value="/page/coach", method= RequestMethod.GET)
	public String coachPage(){
		return "list_student_detail";
	}*/
	


	
}