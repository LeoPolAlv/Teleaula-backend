package com.teleaula.dev.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alumno_evaluacion")
public class AlumnoEvaluacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(length = 400, nullable = true)
	private String observaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_alumno",nullable = false)
	private Alumno alumno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_evaluacion",nullable = false)
	private Evaluacion evaluacion;
	
	
	private static final long serialVersionUID = 1L;

}
