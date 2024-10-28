package com.init.TiendasMass.api.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.init.TiendasMass.api.interfaces.IPedido;
import com.init.TiendasMass.api.interfaces.IProductoRecibido;
import com.init.TiendasMass.api.interfaces.IProductos;
import com.init.TiendasMass.api.modelo.Pedido;
import com.init.TiendasMass.api.modelo.ProductoRecibido;
import com.init.TiendasMass.api.modelo.ProductoPorPedir;
import com.init.TiendasMass.api.modelo.Productos;

@Controller
@RequestMapping
public class ControladorProductoPedido {

	@Autowired
	private IProductos data;
	
	@Autowired 
	private IPedido pedidodata;
	
	@Autowired
	private IProductoRecibido prdata;
	
		private ArrayList<ProductoPorPedir> obtenerCarrito(HttpServletRequest request) {
	    
			@SuppressWarnings("unchecked")
			ArrayList<ProductoPorPedir> carrito = (ArrayList<ProductoPorPedir>) request.getSession().getAttribute("carrito");
		    if (carrito == null) {
		        carrito = new ArrayList<>(); 
		    }
		    return carrito;
		}

		private void guardarCarrito(ArrayList<ProductoPorPedir> carrito, HttpServletRequest request) {
		    request.getSession().setAttribute("carrito", carrito);
		}
	
	@GetMapping(value = "/pedido")
	public String interfazPedido(Model model, HttpServletRequest request) {
	    model.addAttribute("producto", new ProductoPorPedir());
	    float total = 0;
	    ArrayList<ProductoPorPedir> carrito = this.obtenerCarrito(request);
	    for (ProductoPorPedir p: carrito) total += p.getTotal();
	    model.addAttribute("total", total);
	    return "pedido";
	}
	 
	@PostMapping(value = "/agregar")
	public String agregarAlCarrito(@ModelAttribute ProductoPorPedir producto, Float cantidad,HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    
		ArrayList<ProductoPorPedir> carrito = this.obtenerCarrito(request);
	    Productos productoBuscadoPorCodigo = data.findFirstByCodigo(producto.getNombre());
	    if (productoBuscadoPorCodigo == null) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto con ese nombre " + producto.getNombre() + " no existe")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/pedido";
	    }
	    if (productoBuscadoPorCodigo.sinExistencia()) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto está agotado")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/pedido";
	    }
	    boolean encontrado = false;
	    for (ProductoPorPedir productoPorPedir : carrito) {
	        if (productoPorPedir.getNombre().equals(productoBuscadoPorCodigo.getNombre())) {
	        	productoPorPedir.setCantidad(cantidad);
	            encontrado = true;
	            break;
	        }
	    }
	    if (!encontrado) {
	        carrito.add(new ProductoPorPedir(productoBuscadoPorCodigo.getNombre(), productoBuscadoPorCodigo.getCodigo(), productoBuscadoPorCodigo.getPrecio(), productoBuscadoPorCodigo.getExistencia(), productoBuscadoPorCodigo.getIdProducto(), cantidad));
	    }
	    this.guardarCarrito(carrito, request);
	    return "redirect:/pedido";
	}
	
	@PostMapping(value = "/quitar/{indice}")
	public String quitarDelCarrito(@PathVariable int indice, HttpServletRequest request) {
	    ArrayList<ProductoPorPedir> carrito = this.obtenerCarrito(request);
	    if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
	        carrito.remove(indice);
	        this.guardarCarrito(carrito, request);
	    }
	    return "redirect:/pedido";
	}
	
	private void limpiarCarrito(HttpServletRequest request) {
	    this.guardarCarrito(new ArrayList<>(), request);
	}

	@GetMapping(value = "/limpiar")
	public String cancelarPedido(HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    this.limpiarCarrito(request);
	    redirectAttrs
	            .addFlashAttribute("mensaje", "Pedido cancelado")
	            .addFlashAttribute("clase", "info");
	    return "redirect:/listarPedido";
	}
	
	@PostMapping(value = "/terminar")
	public String terminarPedido(HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    ArrayList<ProductoPorPedir> carrito = this.obtenerCarrito(request);
	    
	    if (carrito == null || carrito.size() <= 0) {
	        return "redirect:/listarPedido";
	    }
	    Pedido v = pedidodata.save(new Pedido());
	   
	    for (ProductoPorPedir productoPorPedir : carrito) { 
	        
	        Productos p = data.findById(productoPorPedir.getIdProducto()).orElse(null);
	        if (p == null) continue; // Si es nulo o no existe, ignoramos el siguiente código con continue
	        // Le restamos existencia
	        p.sumarExistencia(productoPorPedir.getCantidad());
	        // Lo guardamos con la existencia ya restada
	        data.save(p);
	        // Creamos un nuevo producto que será el que se guarda junto con la recepcion 
	        ProductoRecibido productoRecibido = new ProductoRecibido(productoPorPedir.getCantidad(), productoPorPedir.getPrecio(), productoPorPedir.getNombre(), productoPorPedir.getCodigo(), v);
	        // Y lo guardamos
	        prdata.save(productoRecibido);
	    }

	    // Al final limpiamos el carrito
	    this.limpiarCarrito(request);
	    // e indicamos una pedido exitoso
	    redirectAttrs
	            .addFlashAttribute("mensaje", "Pedido realizado correctamente")
	            .addFlashAttribute("clase", "success");
	    return "redirect:/listarPedido";
	} 
}


