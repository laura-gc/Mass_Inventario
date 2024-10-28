package com.init.TiendasMass.test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.Proveedores;

public class ProveedoresTest {
	
	@Test
	void test()
	{
		Proveedores proveedor = new Proveedores();
		
		proveedor.setRuc("Bell");
		proveedor.setCorreo("Bell@gmail.com");
		
		assertEquals("Bell", proveedor.getRuc());
		assertEquals("Bell@gmail.com", proveedor.getCorreo());
	}

}
