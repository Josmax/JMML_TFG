package com.ejemplos.spring.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.service.IncidenciaService;
import com.ejemplos.spring.service.MensajeService;
import com.ejemplos.spring.service.UserService;

@Controller
public class IncidenciaController {

	@Autowired
	IncidenciaService service;
	
	@Autowired
	MensajeService serviceMensaje;

	private static final Logger log = LoggerFactory.getLogger(IncidenciaController.class);

	// Listar Usuarios
	@GetMapping("/incidencias")
	public String listUsers(Model m, @Param("palabra")String palabra) {
		//String palabra2 = "002";
		//m.addAttribute("incidenciasList", service.findAll());
		m.addAttribute("incidenciasList", service.findAllFiltro(palabra));
		log.info("Dentro del listado de incidencias");
		return "IncidenciasList";
	}

	@GetMapping("/incidencias/new")
	public String newUser(Incidencia incidencia, Model m) {
		m.addAttribute("incidencia", incidencia);
		return "IncidenciaForm2";
	}
	
	@GetMapping("/incidencias/edit")
	public ModelAndView editIncidencia(@RequestParam("id") int id) {
		//m.addAttribute("incidencia", incidencia);
		//return "IncidenciaForm2";
		ModelAndView modelo = new ModelAndView("IncidenciaEdit");
		Incidencia incidencia = service.findById(id).get();
		modelo.addObject("incidencia", incidencia);
		
		return modelo;
	}

	@GetMapping("/incidencias/delete")
	public String deleteUser(@RequestParam("id") int id) {
		service.deleteById(id);
		log.info("eliminada la incidencia");
		return ("redirect:/incidencias");
	}

	// Guardar Usuario
	@PostMapping("/incidencias/save")
	public String saveUser(@Validated Incidencia incidencia, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			System.out.println("-------> HAY ERRORES");
            return "IncidenciaForm2";
        }
		System.out.println("-------> NO000 HAY ERRORES");
		service.save(incidencia);
		return ("redirect:/incidencias");
	}
	
	// Detalles de una incidencia
	@GetMapping("/incidencias/detalles")
	public String detallesIncidencias(@RequestParam("id") int id, Model m, Model m2) {
		
		serviceMensaje.findAll();
		//System.out.println("--"+ service.findById(id).get());
		//System.out.println("------->"+ serviceMensaje.findByIncidenciaId(id));
		m.addAttribute("incidencia", service.findById(id).get());
		m2.addAttribute("mensajes", serviceMensaje.findByIncidenciaId(id));
		log.info("----->Dentro del listado de incidencias");
		return "IncidenciaDetalles";
	}

}
