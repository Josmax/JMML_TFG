package com.ejemplos.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	private int proceso_id;
	
	@Column(name = "fecha")
	@NotBlank(message = "Introduce la fecha")
	private String fecha;
	
	@Column(name = "hora")
	@NotBlank(message = "Introduce la hora")
	private String hora;
	@Enumerated(EnumType.STRING)
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "incidencia")
	private Incidencia incidencia;
	
	public Proceso(int id, String fecha, String hora, Estado estado) {
		
		this.proceso_id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
	}
}
