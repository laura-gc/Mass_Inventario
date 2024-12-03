package com.init.TiendasMass.api.service;

import java.util.List;
import java.util.Optional;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.TiendasMass.api.interfaces.IAlertas;
import com.init.TiendasMass.api.interfaces.IProductos;
import com.init.TiendasMass.api.interfacesservice.IEmailService;
import com.init.TiendasMass.api.interfacesservice.IProductosService;
import com.init.TiendasMass.api.modelo.Alertas;
import com.init.TiendasMass.api.modelo.Email;
import com.init.TiendasMass.api.modelo.Productos;

@Service
public class ProductosService implements IProductosService{


	@Autowired
	private IProductos data;
	
	@Autowired
	private IAlertas alertasData;
	
	@Autowired
	private IEmailService emailService;
	
	@Override
	public List<Productos> BuscarTodosProductos() {
		// TODO Auto-generated method stub
		return (List<Productos>)data.findAll();
	}

	@Override
	public Optional<Productos> BuscarPorIdProducto(int idProducto) {
		// TODO Auto-generated method stub
		return data.findById(idProducto);
	}

	@Override
	public int guardarProducto(Productos p) throws MessagingException {

		p.setCodigo(p.getNombre());		
		
		
		Alertas a = alertasData.findById(2).orElse(null);
			
			try {
				if(p.getExistencia() <= a.getMinStock()) {
				
					Email email = new Email();
					
					email.setDestinatario(a.getCorreo());
					email.setAsunto("¡Estado mínimo del stock!");
					email.setMensaje("El producto '" + p.getNombre() + "' tiene un stock de: " + p.getExistencia());
					emailService.sendMail(email);
				}
				
				if(p.getExistencia() >= a.getMaxStock()) {
					
					Email email = new Email();
					
					email.setDestinatario(a.getCorreo());
					email.setAsunto("¡Estado máximo del stock!");
					email.setMensaje("El producto '" + p.getNombre() + "' tiene un stock de: " + p.getExistencia());
					emailService.sendMail(email);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
        			throw new MessagingException("Hubo un problema al enviar el correo.", e);
			}
	
		int rs=0;
		Productos productos=data.save(p);
		if (productos.equals(null)) {
			rs=1;
		}
		return rs;		
	}

	@Override
	public void eliminarProducto(int idProducto) {
		// TODO Auto-generated method stub
		data.deleteById(idProducto);
	}
}
