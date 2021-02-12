package com.teleaula.dev.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teleaula.dev.app.models.dao.IAlumnoDao;
import com.teleaula.dev.app.models.entity.Alumno;
import com.teleaula.dev.app.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	private Alumno alumnoReturn;
	
	//@PersistenceContext
	//private EntityManager em;
	
	@Autowired
	private IAlumnoDao alumnoDAO;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> buscaAllAlumnos() {
		
		List<Alumno> alumnos = new ArrayList<>();
		alumnos = alumnoDAO.findAll();
		return alumnos;
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno buscaMatriculaAlumno(String numMatricula) {
		alumnoReturn = alumnoDAO.findByNumeroMatricula(numMatricula);
		return alumnoReturn;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> buscaNombreApellidos(String nombre, String Apellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno buscaDniAlumno(String dni) {
		alumnoReturn = alumnoDAO.findByDni(dni);
		return alumnoReturn;
	}

	@Override
	@Transactional
	public Alumno nuevoAlumno(Alumno alumno) {
		
		alumnoReturn = alumnoDAO.save(alumno);
		
		return alumnoReturn;
	}

	@Override
	@Transactional
	public void borraAlumno(Long id) {
		alumnoDAO.deleteById(id);
		
	}

	/*@Override
	@Transactional
	public void actualizoAlumno(Alumno alumno) {
		
		em.merge(alumno);
		
	}*/

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> buscoAlumnoId(Long id) {
		
		return alumnoDAO.findById(id);
		
	}

	/*@Override
	public List<Alumno> alumnosAsignatura(String cursoEscolar, Asignatura asignatura) {
		
		return alumnoAsignatura.obtengoDatosAsigAnioEscolar(cursoEscolar, asignatura);
	}

	@Override
	public void nuevoAlumnoAsignatura(Alumno alumno) {
		alumnoAsignatura.insertoForaneas(alumno, null);
	}*/
	
	

}
