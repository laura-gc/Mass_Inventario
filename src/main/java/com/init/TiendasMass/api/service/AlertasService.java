package com.init.TiendasMass.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.TiendasMass.api.interfaces.IAlertas;
import com.init.TiendasMass.api.interfacesservice.IAlertasService;
import com.init.TiendasMass.api.modelo.Alertas;

@Service
public class AlertasService implements IAlertasService {

	@Autowired
	private IAlertas data;
	
	@Override
	public int guardarAlerta(Alertas a) {
		
		int rs=0;
		Alertas alertas=data.save(a);
		if (alertas.equals(null)) { 
			rs=1;
		}
		return rs;
	}

	@Override
	public Optional<Alertas> BuscarPorIdAlterta(int idAlerta) {
		
		return data.findById(idAlerta); 
	}

}
