package com.teleaula.dev.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleaula.dev.app.models.dao.IAlumnoAsignaturaDao;
import com.teleaula.dev.app.models.entity.Alumno;
import com.teleaula.dev.app.models.entity.Asignatura;
import com.teleaula.dev.app.models.entity.AsignaturaAlumno;
import com.teleaula.dev.app.service.IAlumnoAsignaturaService;

@Service
public class AlumnoAsignaturaServiceImpl implements IAlumnoAsignaturaService {

	@Autowired
	IAlumnoAsignaturaDao alumnoAsignaturaDao;
	
	@Override
	public List<Alumno> alumnosPorAsignatura(String cursoEscolar, Asignatura asignatura) {
		
		return alumnoAsignaturaDao.obtengoDatosAsigAnioEscolar(cursoEscolar, asignatura);
	}

	@Override
	public List<Asignatura> asignaturasPorAlumno(String cursoEscolar, Alumno alumno) {
		
		return alumnoAsignaturaDao.obtengoDatosAnioEscolar(cursoEscolar, alumno);
	}

	@Override
	public AsignaturaAlumno nuevaRelacion(String cursoEscolar, Optional<Alumno> alumno, Asignatura asignatura) {
	    AsignaturaAlumno asignaturaAlumno = new AsignaturaAlumno();
		
		asignaturaAlumno.setCursoEscolar(cursoEscolar);	
		asignaturaAlumno.setAlumno(alumno.get());
		asignaturaAlumno.setAsignatura(asignatura);
		
		return alumnoAsignaturaDao.save(asignaturaAlumno);
	}

	@Override
	public void borrarRelacion(Long id) {
		alumnoAsignaturaDao.deleteById(id);
	}

}
