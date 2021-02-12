package com.teleaula.dev.app.models.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="evaluaciones", indexes = {@Index(name="periodocurso",columnList = "periodo,curso_escolar")} )
@Getter
@Setter
public class Evaluacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PeriodoEvaluacion periodo;
	
	@Column(name = "curso_escolar", length = 7, nullable = false)
	private String cursoEscolar;
	
	@Column(name = "fecha_evaluacion")
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEvaluacion;
	
	@OneToMany(mappedBy = "evaluacion",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<AlumnoEvaluacion> alumnoEvaluacion;
	
	@OneToMany(mappedBy = "evaluacionId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<Examen> examen;
	
	
	
	private static final long serialVersionUID = 1L;

}
