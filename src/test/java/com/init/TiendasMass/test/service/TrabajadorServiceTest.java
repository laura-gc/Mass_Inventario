package com.init.TiendasMass.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.interfaces.ITrabajador;
import com.init.TiendasMass.api.modelo.Trabajador;
import com.init.TiendasMass.api.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class TrabajadorServiceTest {

	@InjectMocks
	private UsuarioService UsuaSe;
	
	@Mock
	private ITrabajador dataUsuario;
	
	@Test
	void test()
	{	
		Optional<Trabajador> user = UsuaSe.BuscarPorIdUsuario(3);
		
		assertNotNull(user);
 	}
}
