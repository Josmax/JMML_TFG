package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.Mensaje;
import com.ejemplos.spring.repository.MensajeDao;

@Service
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	MensajeDao mensajeDAO;

	public List<Mensaje> findAll() {
		return mensajeDAO.findAll();
	}

	@Override
	public void save(Mensaje mensaje) {
		mensajeDAO.save(mensaje);
	}

	@Override
	public List<Mensaje> findByTitulo(String titulo) {

		mensajeDAO.findByTitulo(titulo);
		return null;
	}

	public List<Mensaje> findByIncidenciaId(int id) {
		return mensajeDAO.findByIncidenciaId(id);
	}

	public List<Mensaje> findByIncidencia(Incidencia incidencia) {
		return mensajeDAO.findByIncidencia(incidencia);
	}

	public void deleteById(int id) {

		mensajeDAO.deleteById(id);
	}
	
	public Optional<Mensaje> findById(int id){
		return mensajeDAO.findById(id);
	}
}
