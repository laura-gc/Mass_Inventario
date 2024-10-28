package com.init.TiendasMass.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.interfaces.ITienda;
import com.init.TiendasMass.api.modelo.Tienda;
import com.init.TiendasMass.api.service.TiendaService;



@ExtendWith(MockitoExtension.class)
public class TiendaServiceTest {

	@InjectMocks
	private TiendaService tienSe;
	
	@Mock
	private ITienda dataTienda;
	
	@Test
	void test()
	{	
		Optional<Tienda> tienda = tienSe.BuscarPorIdTienda(3);
		
		assertNotNull(tienda);
 	}
}
