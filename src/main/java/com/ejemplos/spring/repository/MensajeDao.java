package com.ejemplos.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.Mensaje;

public interface MensajeDao extends JpaRepository<Mensaje,Integer>{

	
	public List<Mensaje> findByTitulo(String titulo);
	
	public List<Mensaje> findByIncidenciaId(int id);
	
	public List<Mensaje> findByIncidencia(Incidencia incidencia);
	
}
