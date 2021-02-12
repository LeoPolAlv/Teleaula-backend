package com.teleaula.dev.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teleaula.dev.app.models.dao.IAlumnoAsignaturaDao;
import com.teleaula.dev.app.models.dao.IAsignaturaDao;
import com.teleaula.dev.app.models.entity.Alumno;
import com.teleaula.dev.app.models.entity.Asignatura;
import com.teleaula.dev.app.models.entity.Ciclo;
import com.teleaula.dev.app.models.entity.TipoAsignatura;
import com.teleaula.dev.app.service.IAsignaturaService;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

	private Asignatura asignaturaAux;
	
	@Autowired
	private IAsignaturaDao asignaturaDao;
	@Autowired
	private IAlumnoAsignaturaDao alumnoAsignatura;
	
	@Override
	@Transactional(readOnly = true)
	public Asignatura buscoAsignaturaPorId(Long id) {
		
		asignaturaAux = asignaturaDao.findById(id).get();
		return asignaturaAux;
	}

	@Override
	@Transactional(readOnly = true)
	public Asignatura buscoAsignaturaPorNombre(String nombre) {
	
		return asignaturaDao.buscarPorNombre(nombre).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> buscoAsignaturas() {
		
		return asignaturaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> buscoAsignaturaPorCicloCurso(Ciclo ciclo, String curso) {
		
		return asignaturaDao.buscoPorCicloCurso(ciclo, curso);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> buscoAsignaturaPorTipo(TipoAsignatura tipoAsignatura) {
		
		return asignaturaDao.buscoPorTipo(tipoAsignatura);
	}

	@Override
	@Transactional
	public Asignatura nuevaAsignatura(Asignatura asignatura) {
		asignaturaAux = asignaturaDao.save(asignatura);
		return asignaturaAux;
	}

	@Override
	@Transactional
	public void borroAsignatura(Long id) {
		asignaturaDao.deleteById(id);
		
	}

	@Override
	public List<Asignatura> asignaturaAlumnos(String cursoEscolar, Alumno alumno) {
		
		return alumnoAsignatura.obtengoDatosAnioEscolar(cursoEscolar, alumno);
		
	}

}
