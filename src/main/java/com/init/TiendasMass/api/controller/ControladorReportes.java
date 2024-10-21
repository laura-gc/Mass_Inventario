package com.init.TiendasMass.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorReportes {
	
	@GetMapping("/reportes")
	public String reportes() {
		
		return "reportes";  
	}

}
