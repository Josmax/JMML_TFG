package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.User;

public interface IncidenciaService {

	// Para listar toda las incidencias.
	public List<Incidencia> findAll();
	// Para Borrar por id
	public void deleteById(int id);

	public void save(Incidencia incidencia);

	public Optional<Incidencia> findById(int id);

	public Incidencia findByCod(String cod);

	public List<Incidencia> findAllFiltro(String palabra);

}


