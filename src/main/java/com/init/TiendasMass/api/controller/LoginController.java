package com.init.TiendasMass.api.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

	@GetMapping({"/","/login"})
	public String index() {
		
		return "Login";  
	}
	
	@GetMapping("/inicio")
	public String menu() {
		return "Inicio";
	}
	 
	 @GetMapping("/accessdenied")
	 public String accessdenied(Model model) {
		 return "Inicio"; 
	 }
	 
	//Para ir a Inicio
	@GetMapping("Inicio")
	public String Inicio() {
		return "Inicio";
	}
	
}
