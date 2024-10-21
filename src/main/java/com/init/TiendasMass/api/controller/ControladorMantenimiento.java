package com.init.TiendasMass.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorMantenimiento {
	
	@GetMapping("/Mantenimiento")
	public String mantenimiento() {
		
		return "Mantenimiento";  
	}

}
