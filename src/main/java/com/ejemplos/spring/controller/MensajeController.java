package com.ejemplos.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.Mensaje;
import com.ejemplos.spring.service.MensajeService;

@Controller
public class MensajeController {

	@Autowired
	MensajeService service;

	@GetMapping("/mensaje/new")
	public String newMensaje(@RequestParam("id") int id, Mensaje mensaje, Model m) {
		m.addAttribute("mensaje", mensaje);
		System.out.println("-----"+mensaje);
		
		//QUIERO ese id Meterlo en el formulario automaticamente en la parte de mensaje.incidencia, lo que viene siendo la relacion wey
		//Como le meto el num id a Incidencia, para crearla en una incidencia.
		return "MensajeForm2";
	}
/*
	@PostMapping("/mensaje/save")
	public String saveUser(Mensaje mensaje) {
		service.save(mensaje);
		return ("redirect:/incidencias");
	}
*/
	@PostMapping("/mensaje/save")
	public String saveUser(@Validated Mensaje mensaje, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("----- Hay algunos errores");
			System.out.println("----- "+mensaje);
			return "MensajeForm2";
			
		} else {
			System.out.println("------> NO HAY ERRORES");
			System.out.println("------> "+ mensaje);
			service.save(mensaje);
			return ("redirect:/incidencias");
		}
	}
}
