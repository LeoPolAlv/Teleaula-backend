package com.teleaula.dev.app.service;

import java.util.List;

import com.teleaula.dev.app.models.entity.Alumno;
import com.teleaula.dev.app.models.entity.Asignatura;
import com.teleaula.dev.app.models.entity.Ciclo;
import com.teleaula.dev.app.models.entity.TipoAsignatura;

public interface IAsignaturaService {
	
	public Asignatura buscoAsignaturaPorId(Long id);
	
	public Asignatura buscoAsignaturaPorNombre(String nombre);
	
	public List<Asignatura> buscoAsignaturas();
	
	public List<Asignatura> buscoAsignaturaPorCicloCurso(Ciclo ciclo, String curso);
	
	public List<Asignatura> buscoAsignaturaPorTipo(TipoAsignatura tipoAsignatura);
	
	public Asignatura nuevaAsignatura(Asignatura asignatura);
	
	public void borroAsignatura(Long id);
	
	public List<Asignatura> asignaturaAlumnos(String cursoEscolar, Alumno alumno);

}
