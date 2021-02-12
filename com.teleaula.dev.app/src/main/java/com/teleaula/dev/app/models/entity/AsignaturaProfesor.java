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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = " asignatura_profesor")
@Getter
@Setter
public class AsignaturaProfesor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "curso_escolar", length = 7, nullable = false)
	private String cursoEscolar;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "asignatura_id")
	private Asignatura asignatura;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;

	private static final long serialVersionUID = 1L;

}
