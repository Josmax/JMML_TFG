package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.controller.IncidenciaController;
import com.ejemplos.spring.controller.MensajeController;


@SpringBootTest
public class Autowired_Controller {

	@Autowired
	private IncidenciaController IncidenciaController;
	
	@Autowired
	private MensajeController MensajeController;
	
	//Dependencias del controller de incidencia
	@Test
	void incidenciaController() {
		assertThat(IncidenciaController).isNotNull();
	}
	
	//Dependencias del controller de mensaje
	@Test
	void mensajeController() {
		assertThat(MensajeController).isNotNull();
	}
	
}



