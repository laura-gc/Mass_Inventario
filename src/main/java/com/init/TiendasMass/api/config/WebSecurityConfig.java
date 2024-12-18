package com.init.TiendasMass.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.init.TiendasMass.api.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 String[] resources = new String[]{
	            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
	    }; 
		
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
		        .antMatchers(resources).permitAll()  
		        .antMatchers("/","/login").permitAll()
		        .antMatchers("/listarCategoria*").hasAuthority("ADMIN")
		        .antMatchers("/listarUsuario*").hasAuthority("ADMIN")
		        .antMatchers("/Mantenimiento*").hasAuthority("ADMIN")
	                .anyRequest().authenticated()
	                .and() 
	            .formLogin()
	                .loginPage("/login")
	                .permitAll() 
	                .defaultSuccessUrl("/Inicio")
	                .failureUrl("/login?error=true")
	                .usernameParameter("username")
	                .passwordParameter("password")
	                .and()
	            .logout() 
	                .permitAll()
	                .logoutSuccessUrl("/login?logout").and()
	                .exceptionHandling()
	                .accessDeniedPage("/accessdenied");
	    }
	    
	    
	   BCryptPasswordEncoder bCryptPasswordEncoder;
	    
	    
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
			bCryptPasswordEncoder = new BCryptPasswordEncoder(4);

	        return bCryptPasswordEncoder;
	    }
		
	    @Autowired
	    UserService userDetailsService;
		
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
	 
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
	    }
}
