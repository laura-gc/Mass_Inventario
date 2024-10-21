package com.init.TiendasMass.api.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.init.TiendasMass.api.modelo.Productos;

public interface IProductos extends CrudRepository<Productos, Integer>{

	 Productos findFirstByCodigo(String codigo);
}
