package com.init.TiendasMass.api.interfaces;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.init.TiendasMass.api.modelo.Pedido;
import com.init.TiendasMass.api.modelo.ProductoRecibido;

public interface IProductoRecibido  extends CrudRepository<ProductoRecibido, Integer> {
	
	public ArrayList<ProductoRecibido> findAllByPedido(Pedido pedido);

}
