package com.init.TiendasMass.api.modelo;

import javax.persistence.*;

@Entity
public class ProductoRecibido {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    private Float cantidad, precio;
	    private String nombre, codigo;
	    
	    @ManyToOne
	    @JoinColumn
	    private Pedido pedido;

	    public ProductoRecibido(Float cantidad, Float precio, String nombre, String codigo, Pedido pedido) {
	        this.cantidad = cantidad;
	        this.precio = precio;
	        this.nombre = nombre;
	        this.codigo = codigo;
	        this.pedido = pedido;
	    }

	    public ProductoRecibido() {
	    }

	    public Float getTotal() {
	        return this.cantidad * this.precio;
	    }

	    public Pedido getPedido() {
	        return pedido;
	    }

	    public void setPedido(Pedido pedido) {
	        this.pedido = pedido;
	    }

	    public Float getPrecio() {
	        return precio;
	    }

	    public void setPrecio(Float precio) {
	        this.precio = precio;
	    }

	    public Float getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(Float cantidad) {
	        this.cantidad = cantidad;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(String codigo) {
	        this.codigo = codigo;
	    }
}
