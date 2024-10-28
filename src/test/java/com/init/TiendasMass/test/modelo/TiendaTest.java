package com.init.TiendasMass.test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.Tienda;

public class TiendaTest {

	@Test
	void test()
	{
		Tienda tienda = new Tienda();
		
		tienda.setNombre("Sede Surco");
		tienda.setFechaRegistro(null);
		
		assertEquals("Sede Surco", tienda.getNombre());
		assertEquals(null, tienda.getFechaRegistro());
	}
}
