package com.init.TiendasMass.api.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alertas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlertas; 
	
	private String correo;
	private int minStock;
	private int maxStock;
	
	public Alertas() {
		super();
	}
	public Alertas(int idAlertas, String correo, int minStock, int maxStock) {
		super();
		this.idAlertas = idAlertas;
		this.correo = correo;
		this.minStock = minStock;
		this.maxStock = maxStock;
	}
	public int getIdAlertas() {
		return idAlertas;
	}
	public void setIdAlertas(int idAlertas) {
		this.idAlertas = idAlertas;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getMinStock() {
		return minStock;
	}
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	public int getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}
}
