package com.init.TiendasMass.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.TiendasMass.api.interfaces.IProveedores;
import com.init.TiendasMass.api.interfacesservice.IProveedoresService;
import com.init.TiendasMass.api.modelo.Proveedores;

@Service
public class ProveedoresService implements IProveedoresService{

	@Autowired//Permite inyectar una dependencia con otra
	private IProveedores data;
	
	//Listar todos los registros
	@Override
	public List<Proveedores> BuscarTodosProveedores() {
		// TODO Auto-generated method stub
		return (List<Proveedores>)data.findAll();
	}

	//Buscar un registro
	@Override
	public Optional<Proveedores> BuscarPorIdProveedor(int idProveedor) {
		// TODO Auto-generated method stub
		return data.findById(idProveedor);
	}
}
