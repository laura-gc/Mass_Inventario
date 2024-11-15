package com.init.TiendasMass.api.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.TiendasMass.api.interfaces.IProductos;
import com.init.TiendasMass.api.interfacesservice.IEmailService;
import com.init.TiendasMass.api.interfacesservice.IProductosService;
import com.init.TiendasMass.api.modelo.Email;
import com.init.TiendasMass.api.modelo.Productos;

@Service
public class ProductosService implements IProductosService{


	@Autowired//Permite inyectar una dependencia con otra
	private IProductos data;
	
	@Autowired
	IEmailService emailService;
	
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
			
			try {
				if(p.getExistencia() < 10 || p.getExistencia() > 100) {
				
					Email email = new Email();
					
					email.setDestinatario("La.gc2204@gmail.com");
					email.setAsunto("Estado del stock");
					email.setMensaje("El producto" + p.getNombre() + "tiene un stock de: " + p.getExistencia());
					emailService.sendMail(email);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
