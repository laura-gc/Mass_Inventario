package com.init.TiendasMass.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.init.TiendasMass.api.interfacesservice.IAlertasService;
import com.init.TiendasMass.api.modelo.Alertas;

@Controller
public class ControladorAlertas {
	
	@Autowired
	private IAlertasService service;
	
	@GetMapping("/alertas")
	public String alertas(Model model) {
		model.addAttribute("alertas", new  Alertas());
		return "alertas";
	}
	
	@PostMapping("/crearAlertas")
	public String crearAlertas(@Validated Alertas a, Model model) {
		service.guardarAlerta(a);
		return "alertas";
	}

}
