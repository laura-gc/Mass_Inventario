package com.init.TiendasMass.api.interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.init.TiendasMass.api.modelo.User;

@Repository 
public interface IUser extends CrudRepository<User, Long> {

	public Optional<User> findByUsername(String username); 
}
