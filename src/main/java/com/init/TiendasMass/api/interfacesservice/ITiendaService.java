package com.init.TiendasMass.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.TiendasMass.api.modelo.Tienda;

public interface ITiendaService {
	public List<Tienda>BuscarTodosTienda();
	public Optional<Tienda>BuscarPorIdTienda(int idTienda);
	public int guardarTienda(Tienda t);
	public void eliminarTienda(int idTienda);
}
