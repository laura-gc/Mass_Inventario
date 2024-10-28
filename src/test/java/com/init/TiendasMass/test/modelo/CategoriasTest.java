package com.init.TiendasMass.test.modelo;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.Categorias;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriasTest {

	@Test
	void test()
	{
		Categorias categorias = new Categorias(); 
		
		categorias.setIdCategoria(40);
		categorias.setDescripcion("Solo");
		categorias.setFechaRegistro(null);
		
		assertEquals(40, categorias.getIdCategoria());
		assertEquals("Solo", categorias.getDescripcion());
		assertEquals(null, categorias.getFechaRegistro());
	}
}
