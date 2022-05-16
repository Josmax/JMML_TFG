package com.ejemplos.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Incidencia;



@Repository
public interface IncidenciaDao extends JpaRepository<Incidencia,Integer>{

	
	public Incidencia findByCod(String cod);
	
	@Query("SELECT i FROM Incidencia i WHERE i.departamento LIKE %?1%"
			+ "OR i.descripcion LIKE %?1%"
			+ "OR i.cod LIKE %?1%")
	public List<Incidencia> findAllFiltro(String palabra);
	
}
