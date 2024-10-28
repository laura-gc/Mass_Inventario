package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.init.TiendasMass.api.controller.ControladorPedido;
import com.init.TiendasMass.api.interfaces.IPedido;
import com.init.TiendasMass.api.interfacesservice.IPedidoService;



@ExtendWith(MockitoExtension.class)
public class ControladorPedidoTest {

	@InjectMocks
	private ControladorPedido conPe;
	
	@Mock
	private IPedido dataPedido;
	
	@Mock
	private IPedidoService service;
	
	@Mock
	Model model;
	
	@Test
	void test()
	{
		
		String pe = conPe.listarPedidos(model);
		
		assertNotNull(pe);
	}
}
