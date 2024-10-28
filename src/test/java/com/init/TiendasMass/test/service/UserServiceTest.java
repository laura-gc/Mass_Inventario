package com.init.TiendasMass.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import com.init.TiendasMass.api.interfaces.IUser;
import com.init.TiendasMass.api.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService userSe;
	
	@Mock
	private IUser dataUser;
	
	private UserDetails usDe;
	
	@Test
	void test()
	{	
		usDe = userSe.loadUserByUsername("Juan");
		
		assertNotNull(usDe);
 	}

}
