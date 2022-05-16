package com.ejemplos.spring.model;

public enum Rol {

	Administrador(1),
	Tecnico(2),
	Cliente(3);
	
	private final int id;
	
	Rol(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}

}
