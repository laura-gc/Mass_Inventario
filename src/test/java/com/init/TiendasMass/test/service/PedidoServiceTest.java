package com.init.TiendasMass.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.interfaces.IPedido;
import com.init.TiendasMass.api.modelo.Pedido;
import com.init.TiendasMass.api.service.PedidoService;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {
	
	@InjectMocks
	private PedidoService pddSe;
	
	@Mock
	private IPedido dataPedido;
	
	@Test
	void test()
	{	
		Optional<Pedido> pedido = pddSe.BuscarPorIdPedido(2);
		
		assertNotNull(pedido);
 	}

}
