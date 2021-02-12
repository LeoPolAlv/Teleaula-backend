package com.teleaula.dev.app.service;

import java.util.List;
import java.util.Optional;

import com.teleaula.dev.app.models.entity.Alumno;


public interface IAlumnoService {

	public Optional<Alumno> buscoAlumnoId(Long id);
	
	public List<Alumno> buscaAllAlumnos();

	public Alumno buscaMatriculaAlumno(String numMatricula);

	public List<Alumno> buscaNombreApellidos(String nombre, String Apellidos);

	public Alumno buscaDniAlumno(String dni);

	public Alumno nuevoAlumno(Alumno alumno);

	public void borraAlumno(Long id);
	
	/*public List<Alumno> alumnosAsignatura(String cursoEscolar, Asignatura asignatura);
	
	public void nuevoAlumnoAsignatura(Alumno alumno);*/

}
