package com.ejemplos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplos.spring.model.Proceso;

public interface ProcesoDao extends JpaRepository<Proceso,Integer>{

}
