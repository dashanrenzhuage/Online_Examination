package edu.mum.onlinetest.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	public String index(){
		return "Homepage";
	}
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(){
		return "login";
	}

}