package com.teleaula.dev.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "asignatura", indexes = { @Index(name = "denominacion_index", columnList = "denominacion", unique = true) })
@Getter
@Setter
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Asignatura implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false, length = 50)
	private String denominacion;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private TipoAsignatura tipo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Ciclo ciclo;

	@Column(nullable = false)
	private String curso;
	
	@Column(nullable = false)
	private String anioEscolar;

	// @JsonManagedReference
	@OneToMany(mappedBy = "asignatura",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AsignaturaAlumno> asignaturasAlumno;
	
	@OneToMany(mappedBy = "asignatura",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AsignaturaProfesor> asignaturasProfesor;
	
	@OneToMany(mappedBy = "asignaturaId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Examen> examen;
	
	@OneToMany(mappedBy = "asignaturaId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LibroTexto> librostexto;

	
	
	private static final long serialVersionUID = 1L;

}
