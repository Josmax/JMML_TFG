package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.Mensaje;

public interface MensajeService {

	public List<Mensaje> findAll();
	// Para Update & Add
	public void save(Mensaje mensaje);

	public List<Mensaje> findByTitulo(String titulo);
	
	public List<Mensaje> findByIncidenciaId(int id);
	
	public List<Mensaje> findByIncidencia(Incidencia incidencia);
}
