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
import com.ejemplos.spring.service.ProcesoService;
import com.ejemplos.spring.service.UserService;

@Controller
public class IncidenciaController {

	@Autowired
	IncidenciaService service;
	
	@Autowired
	MensajeService serviceMensaje;
	
	@Autowired
	ProcesoService serviceProceso;

	private static final Logger log = LoggerFactory.getLogger(IncidenciaController.class);

	// Listar Usuarios
	@GetMapping({"/", "/incidencias"})
	public String listIncidencia(Model m, @Param("palabra")String palabra) {
		//m.addAttribute("incidenciasList", service.findAll());
		m.addAttribute("incidenciasList", service.findAllFiltro(palabra));
		log.info("---- LISTADO DE INCIDENCIAS");
		return "IncidenciasList";
	}

	@GetMapping("/incidencias/new")
	public String newIncidencia(Incidencia incidencia, Model m) {
		m.addAttribute("incidencia", incidencia);
		log.info("---- NUEVA INCIDENCIA");
		return "IncidenciaForm2";
	}
	
	@GetMapping("/incidencias/edit")
	public ModelAndView editIncidencia(@RequestParam("id") int id) {
		//m.addAttribute("incidencia", incidencia);
		//return "IncidenciaForm2";
		log.info("---- EDITAR INCIDENCIA");
		ModelAndView modelo = new ModelAndView("IncidenciaEdit");
		Incidencia incidencia = service.findById(id).get();
		modelo.addObject("incidencia", incidencia);
		
		return modelo;
	}

	@GetMapping("/incidencias/delete")
	public String deleteIncidencia(@RequestParam("id") int id) {
		service.deleteById(id);
		log.info("---- ELIMINAR INCIDENCIA");
		return ("redirect:/");
	}

	// Guardar Incidencia
	@PostMapping("/incidencias/save")
	public String saveIncidencia(@Validated Incidencia incidencia, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			log.info("---- ERRORES AL GUARDAR LA INCIDENCIA");
            return "IncidenciaForm2";
        }
		log.info("---- INCIDENCIA CORRECTA");
		service.save(incidencia);
		return ("redirect:/");
	}
	
	// Detalles de una incidencia
	@GetMapping("/incidencias/detalles")
	public String detallesIncidencias(@RequestParam("id") int id, Model m, Model m2, Model proceso) {
		
		serviceMensaje.findAll();
		m.addAttribute("incidencia", service.findById(id).get());
		m2.addAttribute("mensajes", serviceMensaje.findByIncidenciaId(id));
		log.info("---- Justo ANTES");
		proceso.addAttribute("proceso", serviceProceso.findByIncidenciaId(id));
		//Poner solo el ultimo proceso creado(el estado por ejemplo que seria más descriptivo)
		log.info("---- PROCESOS: "+proceso);
		
		return "IncidenciaDetalles";
	}

}
