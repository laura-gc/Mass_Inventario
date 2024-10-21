package com.init.TiendasMass.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorAlertas {
	
	@GetMapping("/alertas")
	public String alertas() {
		
		return "alertas";  
	}

}
