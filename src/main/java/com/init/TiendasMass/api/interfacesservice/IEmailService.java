package com.init.TiendasMass.api.interfacesservice;

import javax.mail.MessagingException;

import com.init.TiendasMass.api.modelo.Email;

public interface IEmailService {

	public void sendMail(Email email) throws MessagingException;
}
