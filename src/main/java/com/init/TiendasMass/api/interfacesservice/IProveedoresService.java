package com.init.TiendasMass.api.interfacesservice;

import java.util.List;
import java.util.Optional;

import com.init.TiendasMass.api.modelo.Proveedores;

public interface IProveedoresService {
	public List<Proveedores>BuscarTodosProveedores();
	public Optional<Proveedores>BuscarPorIdProveedor(int idProveedor);
}
