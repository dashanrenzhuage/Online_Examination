package edu.mum.onlinetest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(Model model){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username

	      model.addAttribute("username", name);
	    
	      System.out.println("Helooooo"+ name);
		return "login";
	}
	@RequestMapping(value="/loginfailed", method =RequestMethod.GET)
	public String loginerror(Model model) {
	model.addAttribute("error", "true");
	return "login";
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
	return "login";
	}
}
