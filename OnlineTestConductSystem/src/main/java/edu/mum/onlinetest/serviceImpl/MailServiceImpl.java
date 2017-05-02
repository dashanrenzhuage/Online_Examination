package edu.mum.onlinetest.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import edu.mum.onlinetest.model.Email;
import edu.mum.onlinetest.service.MailServiceInterface;

@Service
public class MailServiceImpl  implements MailServiceInterface{
    
	@Autowired
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
    	this.mailSender = mailSender;
    }
    
    
    public void sendMail(Email email) {
    	
    	//creating message
    	SimpleMailMessage message = new SimpleMailMessage();
    	message.setFrom(email.getFromEmail());
    	message.setTo(email.getToEmail());
    	message.setSubject(email.getSubject());
    	message.setText(email.getBody());
    	
    	//sending message
    	mailSender.send(message);
    }
}
