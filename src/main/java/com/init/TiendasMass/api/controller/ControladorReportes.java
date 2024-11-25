package com.init.TiendasMass.api.controller;

import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.init.TiendasMass.api.service.ReportesService;

@Controller
public class ControladorReportes {
	
	private ReportesService reportService;
	
	public ControladorReportes(ReportesService reportService) {
		this.reportService = reportService;
	}
	
	@GetMapping("/reports")
	public ResponseEntity<byte[]> generarReporte()
	{
		try
		{
			byte[] report = reportService.generarReporte("reports");
			HttpHeaders headers = new HttpHeaders();	
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.add("Content-Disposition", "inline; filename=report.pdf");
			
			return new ResponseEntity<byte[]>(report,headers, HttpStatus.OK);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);					
		}
	}



	@GetMapping("/reportes")
	public String reportes() {
		
		return "reportes";  
	}

}
