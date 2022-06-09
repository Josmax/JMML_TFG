package com.ejemplos.spring.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.Mensaje;
import com.ejemplos.spring.service.MensajeService;

@Controller
public class MensajeController {

	@Autowired
	MensajeService service;

	private static final Logger log = LoggerFactory.getLogger(MensajeController.class);

	@GetMapping("/mensaje/new")
	public String newMensaje(@RequestParam("id") int id, Mensaje mensaje, Model m) {
		m.addAttribute("mensaje", mensaje);
		log.info("---- NUEVO MENSAJE SOBRE LA INCIDENCIA ID" + id);
		mensaje.setIncidencia(new Incidencia(id));
		// QUIERO ese id Meterlo en el formulario automaticamente en la parte de
		// mensaje.incidencia, lo que viene siendo la relacion wey
		// Como le meto el num id a Incidencia, para crearla en una incidencia.
		return "MensajeForm2";
	}

	/*
	 * @PostMapping("/mensaje/save") public String saveUser(Mensaje mensaje) {
	 * service.save(mensaje); return ("redirect:/incidencias"); }
	 */
	@PostMapping("/mensaje/save")
	public String saveMensaje(@Validated Mensaje mensaje, BindingResult result) {

		if (result.hasErrors()) {
			log.info("---- ERRORES EN EL FORMULARIO DE MENSAJE");
			return "MensajeForm2";

		} else {
			log.info("---- FORMULARIO DE MENSAJE CORRECTO " + mensaje + " CON INCIDENCIA = " + mensaje.getIncidencia());
			service.save(mensaje);
			return ("redirect:/");
		}
	}

	@GetMapping("/mensaje/delete")
	public String deleteMensaje(@RequestParam("id") int id) {
		service.deleteById(id);
		log.info("---- ELIMINAR MENSAJE");
		return ("redirect:/");
	}

	@GetMapping("/mensaje/edit")
	public ModelAndView editMensaje(@RequestParam("id") int id) {
		log.info("---- EDITAR MENSAJE");
		ModelAndView modelo = new ModelAndView("MensajeEdit");
		Mensaje mensaje = service.findById(id).get();
		modelo.addObject("mensaje", mensaje);

		return modelo;
	}

}
