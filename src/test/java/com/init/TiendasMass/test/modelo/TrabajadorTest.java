package com.init.TiendasMass.test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.Trabajador;

public class TrabajadorTest {
	
	@Test
	void test()
	{
		Trabajador trabajador = new Trabajador();
		
		trabajador.setNombres("Juan");
		trabajador.setApellidos("Perez");
		
		assertEquals("Juan", trabajador.getNombres());
		assertEquals("Perez", trabajador.getApellidos());
	}

}
