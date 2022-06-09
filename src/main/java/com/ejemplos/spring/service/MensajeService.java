package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.Mensaje;

public interface MensajeService {

	public List<Mensaje> findAll();
	// Para Update & Add
	public void save(Mensaje mensaje);

	public void deleteById(int id);
	
	public List<Mensaje> findByTitulo(String titulo);
	
	public List<Mensaje> findByIncidenciaId(int id);
	
	public List<Mensaje> findByIncidencia(Incidencia incidencia);
	
	public Optional<Mensaje> findById(int id);
}
