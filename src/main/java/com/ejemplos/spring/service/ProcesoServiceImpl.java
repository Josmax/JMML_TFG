package com.ejemplos.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejemplos.spring.model.Proceso;
import com.ejemplos.spring.repository.ProcesoDao;

public class ProcesoServiceImpl implements ProcesoService {

	@Autowired
	ProcesoDao service;

	@Override
	public void save(Proceso proceso) {

		service.save(proceso);

	}

}
