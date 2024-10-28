package com.init.TiendasMass.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.TiendasMass.api.interfaces.IPedido;
import com.init.TiendasMass.api.interfacesservice.IPedidoService;
import com.init.TiendasMass.api.modelo.Pedido;

@Service
public class PedidoService implements IPedidoService{

	@Autowired//Permite inyectar una dependencia con otra
	private IPedido data;	

	@Override
	public List<Pedido> BuscarTodosPedido() {
		
		return (List<Pedido>)data.findByEstado("Pendiente");
	} 

	@Override
	public Optional<Pedido> BuscarPorIdPedido(int idPedido) {
		
		return data.findById(idPedido);
	}

	@Override
	public int guardarPedido(Pedido p) {
		
		int rs=0;
		Pedido pedido=data.save(p);
		if (pedido.equals(null)) {
			rs=1;
		}
		return rs;
	}

	@Override
	public void eliminarPedido(int idPedido) {
		
		data.deleteById(idPedido);
		
	}

}
