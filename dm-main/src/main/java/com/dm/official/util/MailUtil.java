package com.dm.official.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailUtil {
	@Autowired
	private static JavaMailSender mailSender;

	public static void send(String from, String to, String subject, String content) throws Exception {
		System.out.println(mailSender == null);
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);

		mailSender.send(message);
	}
}
