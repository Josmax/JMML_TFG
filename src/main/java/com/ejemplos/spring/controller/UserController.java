package com.ejemplos.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplos.spring.model.User;
import com.ejemplos.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	//Listar Usuarios
	@GetMapping("/")
	public String listUsers(Model m) {
		m.addAttribute("userList",service.findAll());
		
		// Para que veas que funciona un método hecho a medida
		//m.addAttribute("userList", service.findByUsername("Antonio"));
		return "UserList";
	}
	
	//Editar Usuarios
	@GetMapping("/edit")
	public String editUser(@RequestParam("id") int id, Model m) {
		//Cuidado porque puede ser nulo. Debo decidir que hacer
		m.addAttribute("user", service.findById(id));
		return "UserForm";
	}
	
	//Eliminar Usuarios
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") int id) {
		service.deleteById(id);
		return ("redirect:/");
	}
	
	//Nuevo Usuario
	@GetMapping("/new")
	public String newUser(User user, Model m) {
		m.addAttribute("user",user);
		return "UserForm";
	}
	
	//Guardar Usuario
	@PostMapping("/save")
	public String saveUser(User user) {
		service.save(user);
		return ("redirect:/");
	}

}
