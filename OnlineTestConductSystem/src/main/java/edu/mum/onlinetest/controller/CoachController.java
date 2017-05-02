package edu.mum.onlinetest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.onlinetest.model.Email;
import edu.mum.onlinetest.serviceImpl.CoachServiceImpl;
import edu.mum.onlinetest.serviceImpl.MailServiceImpl;
import edu.mum.onlinetest.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("coach")
public class CoachController {
	
	@Autowired
	CoachServiceImpl coachService;
	@Autowired
	MailServiceImpl mailService;
	@Autowired
	StudentServiceImpl studentService;
	
	
	@SuppressWarnings("null")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> generateId(@PathVariable("id") Long id){
        //LOG.info("deleting category with id: {}", id);
		String accessId = coachService.generateId();
		System.out.println(accessId);
		
		String body = "Here is the information for login."+"\n"+ "Link :" + "http://localhost:8080/OnlineTestConductSystem/test"+"\n"+"Accessid : "+accessId;
		String subject = "AccessID and Link for Test";
		
		Email email = new Email("Santosh", "santosh.karki044@gmail.com", subject, body);
		Email email1 = new Email("Ashish", "ashish.nembang@gmail.com", subject, body);
		Email email2 = new Email("Rusina", "rusina.shrestha09@gmail.com", subject, body);
		Email email3 = new Email("Sushil", "sushilpokhrel01@gmail.com", subject, body);
		Email email4 = new Email("Bhesh", "bsejawal@gmail.com", subject, body);
		Email email5 = new Email("Deepak", "deepakkc.2045@gmail.com", subject, body);
		Email email6 = new Email("Cong", "cong.ma1991@hotmail.com", subject, body);
	
		
		mailService.sendMail(email);
		mailService.sendMail(email1);
		mailService.sendMail(email2);
		mailService.sendMail(email3);
		mailService.sendMail(email4);
		mailService.sendMail(email5);
		mailService.sendMail(email6);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
