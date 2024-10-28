package com.init.TiendasMass.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.interfaces.IUsuario;
import com.init.TiendasMass.api.modelo.Usuario;
import com.init.TiendasMass.api.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuariosServiceTest {

	@InjectMocks
	private UsuarioService UsuaSe;
	
	@Mock
	private IUsuario dataUsuario;
	
	@Test
	void test()
	{	
		Optional<Usuario> user = UsuaSe.BuscarPorIdUsuario(3);
		
		assertNotNull(user);
 	}
}
