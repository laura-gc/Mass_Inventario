package com.init.TiendasMass.test.modelo;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.Categorias;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class categoriasTest {

	@Test
	void test()
	{
		Categorias categorias = new Categorias(); 
		
		categorias.setIdCategoria(40);
		categorias.setDescripcion("Solo");
		categorias.setFechaRegistro(null);
		
		assertEquals(1, categorias.getIdCategoria());
		assertEquals("Descripción", categorias.getClass());
		assertEquals("Fecha de Registro", categorias.getFechaRegistro());
	}
}
