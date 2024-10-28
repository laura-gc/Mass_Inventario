package com.init.TiendasMass.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.init.TiendasMass.api.interfaces.IUser;
import com.init.TiendasMass.api.interfaces.ITrabajador;
import com.init.TiendasMass.api.interfacesservice.ITrabajadorService;
import com.init.TiendasMass.api.modelo.User;
import com.init.TiendasMass.api.modelo.Trabajador;

@Service
public class UsuarioService implements ITrabajadorService{

	@Autowired//Permite inyectar una dependencia con otra
	private ITrabajador data;

	@Autowired
	private IUser userdata;
	 
	@Override
	public Optional<Trabajador> BuscarPorIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return data.findById(idUsuario);
	} 

	@Override
	public List<Trabajador> BuscarTodosTrabajador() {
		
		return (List<Trabajador>)data.findAll();
	}

	@Override
	public int guardarTrabajador(Trabajador u) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	       
		String clave = bCryptPasswordEncoder.encode(u.getClave());
		int rs=0;

		Trabajador trabajador = new Trabajador();
		
		trabajador.setIdUsuario(u.getIdUsuario());
		trabajador.setNombres(u.getNombres());
		trabajador.setApellidos(u.getApellidos());
		trabajador.setCorreo(u.getCorreo()); 
		trabajador.setUsuario(u.getUsuario());
		trabajador.setClave(clave);
		trabajador.setTipo_Documento(u.getTipo_Documento());
		trabajador.setTienda(u.getTienda());
		trabajador.setFechaRegistro(u.getFechaRegistro()); 
				
				
		Trabajador usuariocreado = data.save(trabajador);	
		
		User user = new User();
		
		user.setUsername(u.getUsuario());
		user.setPassword(clave);
		user.setEnabled(false);
		userdata.save(user);
		
		if (usuariocreado.equals(null)) { 
			rs=1;
		}
		return rs;
		
	}

	@Override
	public void eliminarTrabajador(int idUsuario) {
		// TODO Auto-generated method stub
		data.deleteById(idUsuario);
	}

}
