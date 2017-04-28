package edu.mum.onlinetest.service;

public interface MailServiceInterface {

	public void sendMail(String from, String to, String subject, String msg);
}
