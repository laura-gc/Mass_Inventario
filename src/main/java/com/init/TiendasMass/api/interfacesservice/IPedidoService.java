package com.init.TiendasMass.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.TiendasMass.api.modelo.Pedido;

public interface IPedidoService {
	public List<Pedido>BuscarTodosPedido();
	public Optional<Pedido>BuscarPorIdPedido(int idPedido);
	public int guardarPedido(Pedido p);
	public void eliminarPedido(int idPedido);
}
