package com.ejemplos.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Proceso;
import com.ejemplos.spring.repository.ProcesoDao;

@Service
public class ProcesoServiceImpl implements ProcesoService {

	@Autowired
	ProcesoDao procesoDAO;

	@Override
	public void save(Proceso proceso) {

		procesoDAO.save(proceso);

	}
	
	public List<Proceso> findByIncidenciaId(int id) {
		return procesoDAO.findByIncidenciaId(id);
	}
	
	public List<Proceso> findAll(){
		return procesoDAO.findAll();
	}

	@Override
	public void deleteById(int id) {
		
		procesoDAO.deleteById(id);
		
	}
}
