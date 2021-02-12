package com.teleaula.dev.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teleaula.dev.app.models.entity.Alumno;
import com.teleaula.dev.app.models.entity.Asignatura;
import com.teleaula.dev.app.models.entity.AsignaturaAlumno;

@Repository
public interface IAlumnoAsignaturaDao extends JpaRepository<AsignaturaAlumno, Long> {
	
	@Query("select asignatura from AsignaturaAlumno where cursoEscolar = ?1 and alumno = ?2")
	public List<Asignatura> obtengoDatosAnioEscolar(String cursoEscolar, Alumno idAlumno);
	
	@Query("select alumno from AsignaturaAlumno where cursoEscolar = ?1 and asignatura = ?2")
	public List<Alumno> obtengoDatosAsigAnioEscolar(String cursoEscolar, Asignatura idAsignatura);
	
	@Query("select alumno from AsignaturaAlumno where alumno = ?1")
	public List<AsignaturaAlumno> asignaturasAlumno(Alumno alumno);

}
