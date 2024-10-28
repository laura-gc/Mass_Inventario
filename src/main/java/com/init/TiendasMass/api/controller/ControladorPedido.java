package com.init.TiendasMass.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.init.TiendasMass.api.interfaces.IPedido;
import com.init.TiendasMass.api.interfaces.IProductoRecibido;
import com.init.TiendasMass.api.interfaces.IProductos;
import com.init.TiendasMass.api.interfacesservice.IPedidoService;
import com.init.TiendasMass.api.interfacesservice.IProveedoresService;
import com.init.TiendasMass.api.interfacesservice.ITiendaService;
import com.init.TiendasMass.api.interfacesservice.IUsuarioService;
import com.init.TiendasMass.api.modelo.Pedido;
import com.init.TiendasMass.api.modelo.ProductoRecibido;
import com.init.TiendasMass.api.modelo.Productos;
import com.init.TiendasMass.api.modelo.Proveedores;
import com.init.TiendasMass.api.modelo.Tienda;
import com.init.TiendasMass.api.modelo.Usuario;

@Controller
@RequestMapping
public class ControladorPedido {
	
	@Autowired
	private IPedidoService service;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IProveedoresService proveedoresService;
	
	@Autowired
	private ITiendaService tiendaService;
	
	@Autowired
	private IProductos prodata;
	
	@Autowired
	private IProductoRecibido prdata;
	
	@Autowired 
	private IPedido pedidodata;
	
	
	//Para ir a la lista de todo los registros
	@RequestMapping(value = "listarPedido",method = RequestMethod.GET)
	public String listarPedidos(Model model) {
		List<Pedido>pedidos=service.BuscarTodosPedido();
		model.addAttribute("pedidos", pedidos);
		return "verPedidos";
	}
			
	//Para ir a crear nuevo registro con FK
	@RequestMapping(value = "/crearPedido", method = RequestMethod.GET)
	public String crearPedido(Model model) {
		Pedido pedido =new Pedido();
		
		List<Usuario> listadoUsuario=usuarioService.BuscarTodosUsuario();		
		List<Proveedores> listadoProveedores=proveedoresService.BuscarTodosProveedores();		
		List<Tienda> listadoTienda=tiendaService.BuscarTodosTienda();		
		
		model.addAttribute("pedido", pedido);
		model.addAttribute("lstUsuario", listadoUsuario);
		model.addAttribute("lstProveedores", listadoProveedores);
		model.addAttribute("lstTienda", listadoTienda);
		
		return "crearPedido";
	}
	
	//Para guardar el nuevo registro y ir a listar
	@PostMapping("guardarPedido")
	public String guardarPedido(@ModelAttribute Pedido p,Model model) {
		service.guardarPedido(p);
		return "redirect:/listarPedido";
	}
	
	//Para ir a editar el registro
	@GetMapping("editarPedido/{idPedido}")
	public String editarPedido(@PathVariable int idPedido,Model model) {
		Optional<Pedido>pedido=service.BuscarPorIdPedido(idPedido);
		
		List<Usuario> listadoUsuario=usuarioService.BuscarTodosUsuario();		
		List<Proveedores> listadoProveedores=proveedoresService.BuscarTodosProveedores();		
		List<Tienda> listadoTienda=tiendaService.BuscarTodosTienda();		
		
		model.addAttribute("pedido", pedido);
		model.addAttribute("lstUsuario", listadoUsuario);
		model.addAttribute("lstProveedores", listadoProveedores);
		model.addAttribute("lstTienda", listadoTienda);
		
		return "crearPedido";
	}
	
	//Para ir a eliminar el registro
	@GetMapping("eliminarPedido/{idPedido}")
	public String eliminarPedido(Model model,@PathVariable int idPedido) {
		service.eliminarPedido(idPedido);
		return "redirect:/listarPedido";
	}
	
	@GetMapping("confirmarPedido/{idPedido}")
	public String confirmarPedido(Model model,@PathVariable int idPedido, RedirectAttributes redirectAttrs) {
	
		Pedido pedido = pedidodata.findById(idPedido).orElseGet(null);
		
		for (ProductoRecibido productoRecibido : prdata.findAllByPedido(pedido)) { 
			        
			        Productos p = prodata.findFirstByCodigo(productoRecibido.getCodigo());
			        if (p == null) continue; // Si es nulo o no existe, ignoramos el siguiente código con continue
			        // Le restamos existencia
			        p.sumarExistencia(productoRecibido.getCantidad());
			        // Lo guardamos con la existencia ya sumada
			        prodata.save(p);
			        // Se elimina el producto de guía
			        prdata.deleteById(productoRecibido.getId());
			    }
		pedido.setEstado("Recibido");
		pedidodata.save(pedido);
		
		redirectAttrs
        .addFlashAttribute("mensaje", "Pedido recibido correctamente")
        .addFlashAttribute("clase", "success");
		
		return "redirect:/listarPedido";
	}
	
}
