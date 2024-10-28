package com.init.TiendasMass.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.init.TiendasMass.api.interfaces.IUser;
import com.init.TiendasMass.api.interfaces.IUsuario;
import com.init.TiendasMass.api.interfacesservice.IUsuarioService;
import com.init.TiendasMass.api.modelo.User;
import com.init.TiendasMass.api.modelo.Usuario;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired//Permite inyectar una dependencia con otra
	private IUsuario data;

	@Autowired
	private IUser userdata;
	
	@Override
	public List<Usuario> BuscarTodosUsuario() {
		return (List<Usuario>)data.findAll();
	}
 
	@Override
	public Optional<Usuario> BuscarPorIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return data.findById(idUsuario);
	} 

	@Override
	public int guardarUsuario(Usuario u) {

		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
       
		String clave = bCryptPasswordEncoder.encode(u.getClave());
		int rs=0;

		Usuario usuario = new Usuario();
		
		usuario.setIdUsuario(u.getIdUsuario());
		usuario.setNombres(u.getNombres());
		usuario.setApellidos(u.getApellidos());
		usuario.setCorreo(u.getCorreo()); 
		usuario.setUsuario(u.getUsuario());
		usuario.setClave(clave);
		usuario.setTipo_Documento(u.getTipo_Documento());
		usuario.setTienda(u.getTienda());
		usuario.setFechaRegistro(u.getFechaRegistro()); 
				
				
		Usuario usuariocreado = data.save(usuario);	
		
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
	public void eliminarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		data.deleteById(idUsuario);
	}

}
