package com.init.TiendasMass.test.modelo;

import org.junit.jupiter.api.Test;

import com.init.TiendasMass.api.modelo.Authority;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorityTest {
	
	@Test
	void test()
	{
	  Authority authority = new Authority();
	  
	  authority.setAuthority("admin");
	  
	  assertEquals("admin", authority.getAuthority());
	}

}
