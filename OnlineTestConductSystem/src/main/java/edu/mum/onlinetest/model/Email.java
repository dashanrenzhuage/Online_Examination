package edu.mum.onlinetest.model;

public class Email {

	private String name;
	private String toEmail;
	private String fromEmail;
	private String subject;
	private String body;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [name=" + name + ", toEmail=" + toEmail + ", fromEmail=" + fromEmail + ", subject=" + subject
				+ ", body=" + body + "]";
	}

}
