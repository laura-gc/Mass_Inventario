package com.init.TiendasMass.api.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.init.TiendasMass.api.interfacesservice.IEmailService;
import com.init.TiendasMass.api.modelo.Email;

@RestController
public class EmailController {
	
	@Autowired
	IEmailService emailService;
	
	@PostMapping("/send-email")
	private ResponseEntity<String> sendEmail(@RequestBody Email email) throws MessagingException
	{
		
		emailService.sendMail(email);
		
		return new ResponseEntity<>("Correo enviado exitosamente", HttpStatus.OK);
	}
}
