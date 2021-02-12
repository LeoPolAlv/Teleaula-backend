package com.teleaula.dev.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "examenes")
@Getter
@Setter
public class Examen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	@Column(nullable = false)
	private double calificacion;

	@Column(length = 400, nullable = true)
	private String observaciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evaluacion_id")
	private Evaluacion evaluacionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asignatura_id")
	private Asignatura asignaturaId;

	
	
	
	private static final long serialVersionUID = 1L;

}
