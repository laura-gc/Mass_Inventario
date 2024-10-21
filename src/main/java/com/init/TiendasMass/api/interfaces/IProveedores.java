package com.init.TiendasMass.api.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.init.TiendasMass.api.modelo.Proveedores;

@Repository
public interface IProveedores extends CrudRepository<Proveedores, Integer>{
	
}
