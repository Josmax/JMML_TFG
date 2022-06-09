package com.ejemplos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Proceso;

@Repository
public interface ProcesoDao extends JpaRepository<Proceso,Integer>{

	public List<Proceso> findByIncidenciaId(int id);
}
