package com.init.TiendasMass.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.TiendasMass.api.modelo.Categorias;

public interface ICategoriasService {
	public List<Categorias>BuscarTodosCategorias();
	public Optional<Categorias>BuscarPorIdCategoria(int idCategoria);
	public int guardarCategoria(Categorias c);
	public void eliminarCategoria(int idCategoria);
}
