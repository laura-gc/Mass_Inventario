package com.init.TiendasMass.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.interfaces.IProveedores;
import com.init.TiendasMass.api.modelo.Proveedores;
import com.init.TiendasMass.api.service.ProveedoresService;

@ExtendWith(MockitoExtension.class)
public class ProveedoresServiceTest {

	@InjectMocks
	private ProveedoresService proSe;
	
	@Mock
	private IProveedores dataProveedor;
	
	@Test
	void test()
	{	
		Optional<Proveedores> proveedor = proSe.BuscarPorIdProveedor(2);
		
		assertNotNull(proveedor);
 	}
}
