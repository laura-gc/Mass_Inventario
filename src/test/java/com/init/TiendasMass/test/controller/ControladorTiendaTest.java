package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.init.TiendasMass.api.controller.ControladorTienda;
import com.init.TiendasMass.api.interfaces.ITienda;
import com.init.TiendasMass.api.interfacesservice.ITiendaService;

@ExtendWith(MockitoExtension.class)
public class ControladorTiendaTest {
	
	@InjectMocks
	private ControladorTienda conTi;
	
	@Mock
	private ITienda dataTienda;
	
	@Mock
	private ITiendaService service;
	
	@Mock
	Model model; 
	
	@Test
	void test()
	{
		
		String tienda = conTi.listarTienda(model);
		
		assertNotNull(tienda);
	}

}
