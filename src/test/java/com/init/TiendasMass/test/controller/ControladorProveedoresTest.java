package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.init.TiendasMass.api.controller.ControladorProveedores;
import com.init.TiendasMass.api.interfaces.IProveedores;
import com.init.TiendasMass.api.interfacesservice.IProveedoresService;

@ExtendWith(MockitoExtension.class)
public class ControladorProveedoresTest {

	@InjectMocks
	private ControladorProveedores conPro;
	
	@Mock
	private IProveedores dataProveedores;
	
	@Mock
	private IProveedoresService service;
	
	@Mock
	Model model;
	
	@Test
	void test()
	{
		
		String pro = conPro.listarProveedor(model);
		
		assertNotNull(pro);
	}
}
