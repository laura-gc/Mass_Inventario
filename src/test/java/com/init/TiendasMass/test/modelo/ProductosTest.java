package com.init.TiendasMass.test.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.init.TiendasMass.api.modelo.Productos;

public class ProductosTest {
	
	@Test
	void test()
	{
		Productos producto = new Productos();
		
		producto.setCodigo("C022");
		producto.setNombre("Jabón en polvo");
		producto.setDescripcion("de 500 gr");
		
		assertEquals("C022", producto.getCodigo());
		assertEquals("de 500 gr", producto.getDescripcion());
		assertEquals("Jabón en polvo", producto.getNombre());
		
	}

}
