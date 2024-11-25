package com.init.TiendasMass.api.service;

import java.io.InputStream;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReportesService {
	
	private final DataSource datasource;
	
	public ReportesService(DataSource datasource) {

		this.datasource = datasource;
	}

	public byte [] generarReporte(String nombreReporte) throws Exception
	{
		//Cargar el reporte
		InputStream reporteStream = this.getClass().getResourceAsStream("/reports/"+nombreReporte+".jasper");
		
		Map<String, Object> params = null;
		
		//Llenado
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporteStream, params, datasource.getConnection());
		
		//Exporta a un report tipo pdf
		return JasperExportManager.exportReportToPdf(jasperPrint); 
		
	}

}
