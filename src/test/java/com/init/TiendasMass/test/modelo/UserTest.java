package com.init.TiendasMass.test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.User;

public class UserTest {
	
	@Test
	void test()
	{
		User user = new User();
		
		user.setId( (long) 2);
		user.setUsername("Mass");
		
		assertEquals("Mass", user.getUsername());
		assertEquals(2, user.getId());
	}

}
