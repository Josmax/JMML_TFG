package com.ejemplos.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="mensajes")
public 
@Setter
@Getter
@ToString
@RequiredArgsConstructor
class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mensaje_id")
	private int mensaje_id;
	
	@Column(name = "contenido")
	//@Size(min=3, max=30)
	@NotBlank(message = "Introduce el contenido")
	private String contenido;
	
	@Column(name = "titulo")
	@NotBlank(message = "Introduce el título")
	//@Size(min = 3, message = "titulo debe tener al menos 3 caracteres")
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "incidencia")
	private Incidencia incidencia;
	
	
	
	public Mensaje(int id, String contenido, String titulo, int incidencia) {
		
		this.mensaje_id = id;
		this.contenido = contenido;
		this.titulo = titulo;
		//this.incidencia = incidencia;
	}
}
