package com.teleaula.dev.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "asignatura_alumno")
@Getter
@Setter
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id") 
public class AsignaturaAlumno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "curso_escolar", length = 9, nullable = false)
	private String cursoEscolar;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "asignatura_id")
	@JsonBackReference /* ------ NOTA --------------- */		
	private Asignatura asignatura;

	//@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_alumno")
	private Alumno alumno;

	
	/* NOTA
	 * De esta forma solo se envia los datos de los campos que no entran en la relacion entre tablas.
	 * evitamos la recursion infinita. En la tabla padre se pone esta anotacion @JsonManagedReference
	 */
	
	private static final long serialVersionUID = 1L;

}
