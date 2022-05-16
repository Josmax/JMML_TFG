package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Incidencia;
import com.ejemplos.spring.model.User;
import com.ejemplos.spring.repository.IncidenciaDao;

@Service
public class IncidenciaSerciviceImpl implements IncidenciaService {

	@Autowired
	IncidenciaDao incidenciaDAO;

	public List<Incidencia> findAll() {
		return incidenciaDAO.findAll();
	}

	// Para Borrar por id
	public void deleteById(int id) {
		incidenciaDAO.deleteById(id);
	}

	@Override
	public void save(Incidencia incidencia) {
		incidenciaDAO.save(incidencia);
	}

	@Override
	// Esto es así porque el nuevo metodo devuelve un Optional
	public Optional<Incidencia> findById(int id) {
		return incidenciaDAO.findById(id);
	}

	@Override
	public Incidencia findByCod(String cod) {
		return incidenciaDAO.findByCod(cod);
	}

	@Override
	public List<Incidencia> findAllFiltro(String palabra) {

		if (palabra != null) {
			System.out.println("----->La palabra NONO es NULL"+palabra);
			return incidenciaDAO.findAllFiltro(palabra);
			
		}
		System.out.println("----->La palabra SISI es NULL");
		return incidenciaDAO.findAll();
		
	}
}
