package com.init.TiendasMass.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.interfaces.ICategorias;
import com.init.TiendasMass.api.modelo.Categorias;
import com.init.TiendasMass.api.service.CategoriasService;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

	@InjectMocks
	private CategoriasService cateSer;
	
	@Mock
	private ICategorias dataCategoria;
	
	@Test
	void test()
	{	
		Optional<Categorias> categoria = cateSer.BuscarPorIdCategoria(2);
		
		assertNotNull(categoria);
 	}	
}
