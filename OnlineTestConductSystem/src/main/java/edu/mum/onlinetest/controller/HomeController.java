package edu.mum.onlinetest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value="/home", method= RequestMethod.GET)
	public String index(){
		//return "Homepage";
		return "clickViewPdf";
	}
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(){
		return "login";
	}

}