package com.init.TiendasMass.test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.init.TiendasMass.api.modelo.Pedido;


public class PedidoTest {
	
	@Test
	void test()
	{
		Pedido pedido = new Pedido();
		
		pedido.setId(2);
		pedido.setFechaYHora(null);
		
		assertEquals(2, pedido.getId());
		assertEquals(null, pedido.getFechaYHora());
	}

}
