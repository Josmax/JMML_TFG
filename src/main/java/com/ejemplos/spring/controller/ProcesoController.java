package com.ejemplos.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.Proceso;
import com.ejemplos.spring.service.IncidenciaService;
import com.ejemplos.spring.service.ProcesoService;

@Controller
public class ProcesoController {

	@Autowired
	private ProcesoService service;
	
	@Autowired
	private IncidenciaService serviceIncidencia;

	private static final Logger log = LoggerFactory.getLogger(ProcesoController.class);

	@PostMapping("/proceso/save")
	public String saveProceso(@Validated Proceso proceso, BindingResult result) {

		if (result.hasErrors()) {
			log.info("---- ERRORES EN EL FORMULARIO DE MENSAJE");
			return "ProcesoForm";

		} else {
			log.info("---- FORMULARIO DE MENSAJE CORRECTO " + proceso);
			service.save(proceso);
			return ("redirect:/");
		}
	}

	@GetMapping("/proceso/new")
	public String newProceso(@RequestParam("id") int id, Proceso proceso, Model m) {
		m.addAttribute("proceso", proceso);
		log.info("---- NUEVO PROCESO SOBRE LA INCIDENCIA ID" + id);
		proceso.setIncidencia(new Incidencia(id));
		return "ProcesoForm";
	}

	@GetMapping("/procesos")
	public String listadoProcesos(Model proceso) {

		log.info("---- DETALLES DE PROCESO");
		proceso.addAttribute("proceso", service.findAll());
		log.info("---- PROCESOS: " + proceso);

		return "ProcesosDetalles";
	}

	// Detalles de una incidencia
	@GetMapping("/procesos/detalles")
	public String detallesProcesos(@RequestParam("id") int id, Model proceso, Model incidencia) {

		log.info("---- DETALLES DE PROCESO");
		proceso.addAttribute("proceso", service.findByIncidenciaId(id));
		incidencia.addAttribute("incidencia", serviceIncidencia.findById(id).get());
		log.info("---- INCIDENCIA: " + serviceIncidencia.findById(id));

		return "ProcesosDetalles";
	}
	
	@GetMapping("/proceso/delete")
	public String deleteProceso(@RequestParam("id") int id) {
		service.deleteById(id);
		log.info("---- ELIMINAR PROCESO");
		return ("redirect:/");
	}

}
