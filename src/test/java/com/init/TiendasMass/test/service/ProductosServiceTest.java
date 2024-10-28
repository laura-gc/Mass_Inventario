package com.init.TiendasMass.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.interfaces.IProductos;
import com.init.TiendasMass.api.modelo.Productos;
import com.init.TiendasMass.api.service.ProductosService;

@ExtendWith(MockitoExtension.class)
public class ProductosServiceTest {
	
	@InjectMocks
	private ProductosService proSe;
	
	@Mock
	private IProductos dataProducto;
	
	@Test
	void test()
	{	
		Optional<Productos> producto = proSe.BuscarPorIdProducto(2);
		
		assertNotNull(producto);
 	}

}
