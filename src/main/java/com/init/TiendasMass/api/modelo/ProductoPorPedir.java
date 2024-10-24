package com.init.TiendasMass.api.modelo;

public class ProductoPorPedir  extends Productos {

	 private Float cantidad;

	    public ProductoPorPedir(String nombre, String codigo, Float precio, Float existencia, Integer id) {
		super(nombre, codigo, precio, existencia, id);
	}

		public ProductoPorPedir() {
		super();
	}

		public ProductoPorPedir(String nombre, String codigo, Float precio, Float existencia, Integer id, Float cantidad) {
	        super(nombre, codigo, precio, existencia, id);
	        this.cantidad = cantidad;
	    }

	    public ProductoPorPedir(String nombre, String codigo, Float precio, Float existencia, Float cantidad) {
	        super(nombre, codigo, precio, existencia);
	        this.cantidad = cantidad;
	    }

	    public Float getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(Float cantidad) {
			this.cantidad = cantidad;
		}

		public Float getTotal() {
	        return this.getPrecio() * this.cantidad;
	    }
}
