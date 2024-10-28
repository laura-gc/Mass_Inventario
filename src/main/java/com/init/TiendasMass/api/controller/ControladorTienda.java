package com.init.TiendasMass.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.init.TiendasMass.api.interfacesservice.ITiendaService;
import com.init.TiendasMass.api.modelo.Tienda;

@Controller
@RequestMapping
public class ControladorTienda {
	@Autowired
	private ITiendaService service;
	
	//Para ir a la lista de todo los registros
	@GetMapping("listarTienda")
	public String listarTienda(Model model) {
		List<Tienda>tienda=service.BuscarTodosTienda();
		model.addAttribute("tienda", tienda);
		return "listarTienda";
	}
	
	//Para ir a crear nuevo registro
	@GetMapping("crearTienda")
	public String crearTienda(Model model) {
		model.addAttribute("tienda", new  Tienda());
		return "crearTienda";
	}	
}
