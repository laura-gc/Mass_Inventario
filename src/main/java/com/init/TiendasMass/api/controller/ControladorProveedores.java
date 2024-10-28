package com.init.TiendasMass.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.init.TiendasMass.api.interfacesservice.IProveedoresService;
import com.init.TiendasMass.api.modelo.Proveedores;


@Controller 
@RequestMapping
public class ControladorProveedores {
	
	@Autowired
	private IProveedoresService service;
	
	//Para ir a la lista de todo los registros
	@GetMapping("listarProveedor")
	public String listarProveedor(Model model) {
		List<Proveedores>proveedores=service.BuscarTodosProveedores();
		model.addAttribute("proveedores", proveedores);
		return "listarProveedor";
	}		
}
