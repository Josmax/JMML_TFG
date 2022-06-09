package com.ejemplos.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "incidencias")
public @Setter @Getter @ToString
//@RequiredArgsConstructor
class Incidencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "incidencia_id")
	private int id;

	@Column(name = "cod")
	@NotBlank(message = "Debes introducir un COD")
	private String cod;

	@Column(name = "descripcion")
	@Size(min = 1, max = 50, message = "La descripcion debe medir entre 1 y 50")
	@NotBlank(message = "Introduce una descripción")
	private String descripcion;

	@NotBlank(message = "Debes introducir el departamento")
	@Size(min = 1, max = 50, message = "El departamento debe medir entre 1 y 50")
	@Column(name = "departamento")
	private String departamento;

	@Column(name = "cliente")
	private String cliente;

	public Incidencia(int id, String cod, String descripcion, String departamento) {

		this.id = id;
		this.cod = cod;
		this.descripcion = descripcion;
		this.departamento = departamento;

	}

	public Incidencia(int id) {
		this();
		this.id = id;
	}
	public Incidencia() {

		super();
	}
}
