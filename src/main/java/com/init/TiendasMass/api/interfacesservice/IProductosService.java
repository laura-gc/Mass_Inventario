package com.init.TiendasMass.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import com.init.TiendasMass.api.modelo.Productos;

public interface IProductosService {
	public List<Productos>BuscarTodosProductos();
	public Optional<Productos>BuscarPorIdProducto(int idProducto);
	public int guardarProducto(Productos p) throws MessagingException;
	public void eliminarProducto(int idProducto);
}
