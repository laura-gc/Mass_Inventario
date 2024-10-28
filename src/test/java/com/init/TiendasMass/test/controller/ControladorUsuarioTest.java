package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.init.TiendasMass.api.controller.ControladorUsuario;
import com.init.TiendasMass.api.interfaces.IUsuario;
import com.init.TiendasMass.api.interfacesservice.IUsuarioService;

@ExtendWith(MockitoExtension.class)
public class ControladorUsuarioTest {
	
	@InjectMocks
	private ControladorUsuario conUser;
	
	@Mock
	private IUsuario dataUsurio;
	
	@Mock
	private IUsuarioService service;
	
	@Mock
	Model model;
	
	@Test
	void test()
	{
		
		String user = conUser.listarUsuario(model);
		
		assertNotNull(user);
	}

}
