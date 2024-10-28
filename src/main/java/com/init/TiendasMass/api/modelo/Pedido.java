package com.init.TiendasMass.api.modelo;

import java.util.Set;

import javax.persistence.*;

import com.init.TiendasMass.api.util.Hora;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdPedido;

	private String fechaYHora;
	
	private String estado;
	
	 @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	    private Set<ProductoRecibido> productos;
	
	public int getIdPedido() {
		return IdPedido;
	}
	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}
	
    
    public Pedido() {
        this.fechaYHora = Hora.obtenerFechaYHoraActual();
    } 

    public Integer getId() {
        return IdPedido;
    }

    public void setId(Integer id) {
        this.IdPedido = id;
    }

    public Float getTotal() {
        Float total = 0f;
        for (ProductoRecibido productoRecibido : this.productos) {
            total += productoRecibido.getTotal();
        }
        return total;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    
    public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Set<ProductoRecibido> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoRecibido> productos) {
        this.productos = productos;
    }
	
	
}
