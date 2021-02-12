package com.teleaula.dev.app.service;

import java.util.List;
import java.util.Optional;

import com.teleaula.dev.app.models.entity.Alumno;
import com.teleaula.dev.app.models.entity.Asignatura;
import com.teleaula.dev.app.models.entity.AsignaturaAlumno;

public interface IAlumnoAsignaturaService {
	
	public List<Alumno> alumnosPorAsignatura(String cursoEscolar, Asignatura asignatura);
	
	public List<Asignatura> asignaturasPorAlumno(String cursoEscolar, Alumno alumno);
	
	public AsignaturaAlumno nuevaRelacion(String cursoEscolar, Optional<Alumno> alumnoId, Asignatura asignatura);
	
	public void borrarRelacion(Long id);
	
	//public buscoAsignaturasAlumno
	
}
