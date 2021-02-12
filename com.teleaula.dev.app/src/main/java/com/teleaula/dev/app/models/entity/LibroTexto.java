package com.teleaula.dev.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "libro_texto")
@Getter
@Setter
public class LibroTexto implements Serializable {

	@NotEmpty
	@Id
	private String ISBN;

	@NotEmpty
	private String denominacion;

	@NotEmpty
	@Column(nullable = false)
	private String editorial;

	@NotEmpty
	@Column(name = "anio_edicion")
	private String anioedicion;

	@NotEmpty
	@Column(nullable = false)
	private TipoLibroTexto tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asignatura_id")
	private Asignatura asignaturaId;

	private static final long serialVersionUID = 1L;

}
