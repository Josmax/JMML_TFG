package com.ejemplos.spring.model;


public enum Estado {

	Pendiente("Pendiente"),
	Resuelta("Resuelta"),
	Procesando("Procesando"), 
	SinSolucion("SinSolucion");
	
	private final String estado;
	
	Estado(String estado) {
		this.estado=estado;
	}
	public String getEstado() {
		return estado;
	}
	

}
