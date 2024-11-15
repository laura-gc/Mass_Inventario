package com.init.TiendasMass.api.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.init.TiendasMass.api.interfacesservice.IEmailService;
import com.init.TiendasMass.api.modelo.Email;

@Service
public class EmailService implements IEmailService {
	
	private final JavaMailSender javaMailSender;
	
	private final TemplateEngine templateEngine;

	public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
		super();
		this.javaMailSender = javaMailSender;
		this.templateEngine = templateEngine;
	}
	
	@Override
	public void sendMail(Email email) throws MessagingException
	{
		try
		{
			MimeMessage message = javaMailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			
			helper.setTo(email.getDestinatario());
			helper.setSubject(email.getAsunto());
			
			Context context = new Context();
			
			context.setVariable("message", email.getMensaje());
			String contentHtmal = templateEngine.process("email", context);
			
			helper.setText(contentHtmal, true);
			
			javaMailSender.send(message);
			
		}catch (Exception e) {
			throw new RuntimeException("Error al enviar el correo " + e.getMessage(), e); 
		}
	}

}
