package com.init.TiendasMass.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.TiendasMass.api.modelo.Trabajador;

public interface ITrabajadorService {
	public List<Trabajador>BuscarTodosTrabajador();
	public Optional<Trabajador>BuscarPorIdUsuario(int idUsuario);
	public int guardarTrabajador(Trabajador u);
	public void eliminarTrabajador(int idUsuario);
}
