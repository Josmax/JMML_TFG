package com.ejemplos.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder usuarios = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(usuarios.username("admin").password("123").roles("administrador"))
			.withUser(usuarios.username("tecnico").password("123").roles("tecnico"))
			.withUser(usuarios.username("cliente").password("123").roles("cliente"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*http.authorizeRequests().anyRequest().authenticated().and().formLogin()
			.permitAll()
			.and().logout().permitAll();*/
		
		//http.authorizeRequests().antMatchers("/incidencias/edit").hasAnyRole("administrador")
		//.anyRequest().authenticated();
		
		//Autorizaciones de los Roles
		
		http.authorizeRequests()
		//Incidencia
		.antMatchers("/incidencias/edit").hasAnyRole("tecnico")
		.antMatchers("/incidencias/delete").hasAnyRole("tecnico")
		.antMatchers("/incidencias/edit").hasAnyRole("administrador")
		.antMatchers("/incidencias/delete").hasAnyRole("administrador")
		//Mensajes
		.antMatchers("/mensaje/delete").hasAnyRole("tecnico")
		.antMatchers("/mensaje/edit").hasAnyRole("tecnico")
		.antMatchers("/mensaje/delete").hasAnyRole("administrador")
		.antMatchers("/mensaje/edit").hasAnyRole("administrador")
		//Proceso
		.antMatchers("/proceso/delete").hasAnyRole("administrador")
		.antMatchers("/proceso/new").hasAnyRole("administrador")
		.antMatchers("/proceso/delete").hasAnyRole("tecnico")
		.antMatchers("/proceso/new").hasAnyRole("tecnico")
		
		.anyRequest().authenticated().and().formLogin()
		.permitAll()
		.and().logout().permitAll();
		
		
	}	

	
	
}
