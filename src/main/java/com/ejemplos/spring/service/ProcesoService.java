package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Proceso;

public interface ProcesoService {

	public void save(Proceso proceso);

	public List<Proceso> findByIncidenciaId(int id);

	public List<Proceso> findAll();

	public void deleteById(int id);
}
