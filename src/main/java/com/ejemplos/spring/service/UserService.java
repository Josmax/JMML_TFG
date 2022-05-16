package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.User;

public interface UserService {
	
	//Para Listar Todos
	public List<User> findAll();
	
	//Para recuperar usuario
	public Optional<User> findById(int id);
	
	//Para Update & Add
	public void save(User user);
	
	//Para Borrar por id
	public void deleteById(int id);
	
	//Custom
	public List<User> findByUsername(String username);
	

}
