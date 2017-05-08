package edu.mum.onlinetest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller


public class HomeController {
	@RequestMapping("/")
	public String login(){
		
		return "login";
	}
	


}