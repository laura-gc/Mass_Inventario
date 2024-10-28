package com.init.TiendasMass.test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.Usuario;

public class UsuarioTest {
	
	@Test
	void test()
	{
		Usuario usuario = new Usuario();
		
		usuario.setNombres("Juan");
		usuario.setApellidos("Perez");
		
		assertEquals("Juan", usuario.getNombres());
		assertEquals("Perez", usuario.getApellidos());
	}

}
