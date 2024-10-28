package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.init.TiendasMass.api.controller.ControladorProductoPedido;
import com.init.TiendasMass.api.interfacesservice.IProductosService;
import com.init.TiendasMass.api.modelo.ProductoPorPedir;



@ExtendWith(MockitoExtension.class)
public class ControladorProductoPedidoTest {
	
	@InjectMocks
	private ControladorProductoPedido conPro;
	
	@Mock
	private ProductoPorPedir pro;
	
	@Mock
	private IProductosService service;
	
	@Mock
	RedirectAttributes redirec;
	
	@Mock
	HttpServletRequest request;
	
	@Test
	void test()
	{
		
		String pe = conPro.terminarPedido(request, redirec);
		
		assertNotNull(pe);
	}

}
