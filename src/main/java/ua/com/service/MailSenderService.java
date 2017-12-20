package ua.com.service;

public interface MailSenderService {
	void sendMail(String context,String mailBody,String email);
}
