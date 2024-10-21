package com.init.TiendasMass.api.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.init.TiendasMass.api.modelo.Pedido;

public interface IPedido extends CrudRepository<Pedido, Integer> {

}
