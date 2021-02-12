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
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alumnos", indexes = { @Index(name = "dni_index", columnList = "dni", unique = true),
		@Index(columnList = "numero_matricula", name = "matricula_index", unique = true) })
@Getter
@Setter
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Alumno implements Serializable {

	// Con esto evitamos la recursividad en la informacion en formato JSON que se envia. Se usa para enviar con un registro de esta entidad
	// varias filas que se encuentran en la tabla unida a esta por la relacion 1:N.
	@JsonManagedReference
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(nullable = false, length = 200)
	private String apellidos;

	@Email
	@Column(nullable = false)
	private String email;

	@Column(name = "fecha_nacimiento")
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

	@Column(nullable = false, length = 200)
	private String direccion;

	@Column(nullable = false, length = 50)
	private String provincia;

	@Column(nullable = false, length = 50)
	private String localidad;

	@Column(name = "codigo_postal", nullable = false, length = 5)
	private String codigoPostal;

	@Column(name = "dni", nullable = false, length = 10)
	private String dni;

	@Column(name = "numero_matricula", nullable = false, length = 20)
	private String numeroMatricula;

	@Column(name = "fecha_matricula")
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaMatricula;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Ciclo ciclo;

	@Column(nullable = false)
	private String curso;
	
	// @JsonManagedReference
	@OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<AsignaturaAlumno> asignaturasAlumno;

	@OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<AlumnoEvaluacion> alumnoEvaluacion;

	private static final long serialVersionUID = 1L;

}
