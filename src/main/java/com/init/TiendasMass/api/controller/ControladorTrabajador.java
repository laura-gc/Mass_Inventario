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

import com.init.TiendasMass.api.interfacesservice.ITiendaService;
import com.init.TiendasMass.api.interfacesservice.ITrabajadorService;
import com.init.TiendasMass.api.modelo.Tienda;
import com.init.TiendasMass.api.modelo.Trabajador;

@Controller
@RequestMapping
public class ControladorTrabajador {
	@Autowired
	private ITrabajadorService service;
	
	@Autowired
	private ITiendaService tiendaService;
	
	//Para ir a la lista de todo los registros
	@GetMapping("listarTrabajador")
	public String listarTrabajador(Model model) {
		List<Trabajador>trabajador=service.BuscarTodosTrabajador();
		model.addAttribute("usuario", trabajador);
		return "listarTrabajador";
	}
			
	//Para ir a crear nuevo registro con FK
	@GetMapping("/crearTrabajador")
	public String crearTrabajador(Model model) {
		Trabajador trabajador =new Trabajador();
		
		List<Tienda> listadoTienda=tiendaService.BuscarTodosTienda();
		
		
		model.addAttribute("titulo","Agregar Usuario");
		model.addAttribute("usuario", trabajador);
		model.addAttribute("lstTienda", listadoTienda);
		
		return "crearTrabajador";
	}
	
	//Para guardar el nuevo registro y ir a listar
	@PostMapping("guardarTrabajador")
	public String guardarUsuario(@ModelAttribute Trabajador u,Model model) {
		service.guardarTrabajador(u);
		return "redirect:/listarTrabajador";
	}
	
	//Para ir a editar el registro
	@GetMapping("editarTrabajador/{idUsuario}")
	public String editarTrabajador(@PathVariable int idUsuario,Model model) {
		Optional<Trabajador>trabajador=service.BuscarPorIdUsuario(idUsuario);
		
		List<Tienda> listadoTienda=tiendaService.BuscarTodosTienda();
		
		model.addAttribute("titulo","Agregar Usuario");
		model.addAttribute("usuario", trabajador);
		model.addAttribute("lstTienda", listadoTienda);

		
		return "crearTrabajador";
	}
	
	//Para ir a eliminar el registro
	@GetMapping("eliminarTrabajador/{idUsuario}")
	public String eliminarTrabajador(Model model,@PathVariable int idUsuario) {
		service.eliminarTrabajador(idUsuario);
		return "redirect:/listarTrabajador";
	}
}
