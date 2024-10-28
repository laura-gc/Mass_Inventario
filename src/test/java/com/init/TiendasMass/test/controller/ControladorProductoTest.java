package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.init.TiendasMass.api.controller.ControladorProductos;
import com.init.TiendasMass.api.interfaces.IProductos;
import com.init.TiendasMass.api.interfacesservice.IProductosService;


@ExtendWith(MockitoExtension.class)
public class ControladorProductoTest {
	
	@InjectMocks
	private ControladorProductos conPro;
	
	@Mock
	private IProductos dataProductos;
	
	@Mock
	private IProductosService service;
	
	@Mock
	Model model;
	
	@Test
	void test()
	{
		
		String pro = conPro.listarProductos(model);
		
		assertNotNull(pro);
	}
}
