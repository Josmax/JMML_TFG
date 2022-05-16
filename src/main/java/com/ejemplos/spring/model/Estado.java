package com.ejemplos.spring.model;


public enum Estado {

	Pendiente(1),
	Resuelto(2),
	Procesando(3), 
	SinSolucion(4);
	
	private final int id;
	
	Estado(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	

}
