package com.ejemplos.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "procesos")
public @Setter @Getter @ToString @RequiredArgsConstructor class Proceso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proceso_id")
	private int id;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "hora")
	private String hora;

	public Proceso(int id, String fecha, String hora) {
		
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
	}
}
