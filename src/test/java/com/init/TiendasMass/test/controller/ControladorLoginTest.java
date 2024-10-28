package com.init.TiendasMass.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.init.TiendasMass.api.controller.LoginController;



@ExtendWith(MockitoExtension.class)
public class ControladorLoginTest {
	
	@InjectMocks
	private LoginController conLog;
	
	@Test
	void test()
	{
		
		String log = conLog.menu();
		
		assertNotNull(log);
	}

}
