
package com.dm.official.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dm.official.service.BaseService;
import com.dm.official.service.MailService;

@Service
public class MailServiceImpl extends BaseService implements MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void send(SimpleMailMessage message) {
		mailSender.send(message);
		System.out.println("send message successfully.");
	}
}
