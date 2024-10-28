package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.init.TiendasMass.api.controller.ControladorTrabajador;
import com.init.TiendasMass.api.interfaces.ITrabajador;
import com.init.TiendasMass.api.interfacesservice.ITrabajadorService;

@ExtendWith(MockitoExtension.class)
public class ControladorTrabajadorTest {
	
	@InjectMocks
	private ControladorTrabajador conUser;
	
	@Mock
	private ITrabajador dataUsurio;
	
	@Mock
	private ITrabajadorService service;
	
	@Mock
	Model model;
	
	@Test
	void test()
	{
		
		String user = conUser.listarTrabajador(model);
		
		assertNotNull(user);
	}

}
