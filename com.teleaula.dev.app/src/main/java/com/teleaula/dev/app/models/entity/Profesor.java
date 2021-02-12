package com.teleaula.dev.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profesores", indexes = { @Index(name = "dni_index", columnList = "dni", unique = true) })
@Getter
@Setter
public class Profesor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "id")
	private Long idProfesor;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(nullable = false, length = 200)
	private String apellido;

	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@Column(nullable = false, length = 200)
	private String direccion;

	@Column(nullable = false, length = 50)
	private String localidad;

	@Column(nullable = false, length = 50)
	private String codigoPostal;

	@Email
	@Column(nullable = false)
	private String email;

	@Column(name = "dni", nullable = false, length = 10)
	private String DNI;
	
	@OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AsignaturaProfesor> profesor;

	private static final long serialVersionUID = 1L;

}
