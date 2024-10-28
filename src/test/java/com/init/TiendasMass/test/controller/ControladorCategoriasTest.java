package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.controller.ControladorCategorias;
import com.init.TiendasMass.api.interfaces.ICategorias;
import com.init.TiendasMass.api.interfacesservice.ICategoriasService;

import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class ControladorCategoriasTest {
	
	@InjectMocks
	private ControladorCategorias conCat;
	
	@Mock
	private ICategorias dataCategoria;
	
	@Mock
	private ICategoriasService service;
	
	@Mock
	Model model;
	
	@Test
	void test()
	{
		
		String cat = conCat.listarCategoria(model);
		
		assertNotNull(cat);
	}

}
