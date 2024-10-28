package com.init.TiendasMass.test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.ProductoRecibido;

public class ProductoRecibidoTest {


	@Test
	void test()
	{
		ProductoRecibido proRe = new ProductoRecibido();
		
		proRe.setNombre("Jabón en Polvo");
		proRe.setCantidad( (float) 55);
		
		assertEquals("Jabón en Polvo", proRe.getNombre());
		assertEquals(55, proRe.getCantidad());
	}
}
