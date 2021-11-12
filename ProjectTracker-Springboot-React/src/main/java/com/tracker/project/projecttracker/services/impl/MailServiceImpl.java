package com.tracker.project.projecttracker.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tracker.project.projecttracker.models.Mail;
import com.tracker.project.projecttracker.services.MailService;

@Service
public class MailServiceImpl implements MailService{
	
	JavaMailSender emailSender;
	
	@Autowired
	MailServiceImpl(JavaMailSender emailSender){
		this.emailSender = emailSender;
	}

	@Override
	public void sendEmail(Mail mail) {

		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		
		this.emailSender.send(message);
		
	}

}
