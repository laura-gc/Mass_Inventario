package com.init.TiendasMass.test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.ProductoPorPedir;

public class ProductoPorPedirTest {

	@Test
	void test()
	{
		ProductoPorPedir proPe = new ProductoPorPedir();
		
		proPe.setCantidad(Float.parseFloat("55"));
		proPe.setNombre("Jabón en Polvo");
		
		assertEquals(55, proPe.getCantidad());
		assertEquals("Jabón en Polvo", proPe.getNombre());
	}
}
