package com.init.TiendasMass.api.interfacesservice;

import java.util.Optional;

import com.init.TiendasMass.api.modelo.Alertas;

public interface IAlertasService {
	
	public int guardarAlerta(Alertas a);
	public Optional<Alertas>BuscarPorIdAlterta(int idAlerta);  

}
