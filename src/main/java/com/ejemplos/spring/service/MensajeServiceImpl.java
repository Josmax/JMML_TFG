package com.ejemplos.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.Mensaje;
import com.ejemplos.spring.repository.MensajeDao;

@Service
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	MensajeDao service;

	public List<Mensaje> findAll(){
		return service.findAll();
	}
	
	@Override
	public void save(Mensaje mensaje) {
		service.save(mensaje);
		
	}

	@Override
	public List<Mensaje> findByTitulo(String titulo) {
		
		service.findByTitulo(titulo);
		return null;
	}
	
	public List<Mensaje> findByIncidenciaId(int id){
		return service.findByIncidenciaId(id);
	}

	public List<Mensaje> findByIncidencia(Incidencia incidencia){
		return service.findByIncidencia(incidencia);
	}
}
