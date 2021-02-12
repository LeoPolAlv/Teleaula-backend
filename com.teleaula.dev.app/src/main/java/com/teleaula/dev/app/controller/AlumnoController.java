package com.teleaula.dev.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.teleaula.dev.app.models.entity.Alumno;
import com.teleaula.dev.app.models.entity.Asignatura;
import com.teleaula.dev.app.service.IAlumnoAsignaturaService;
import com.teleaula.dev.app.service.IAsignaturaService;
import com.teleaula.dev.app.service.impl.AlumnoServiceImpl;

@RestController
@RequestMapping(value = "/alumno")
@SessionAttributes("alumno")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
public class AlumnoController {

	@Autowired
	private AlumnoServiceImpl alumnoService;
	
	@Autowired
	private IAsignaturaService asignaturaService;
	
	@Autowired
	private IAlumnoAsignaturaService alumnoAsignatura;

	private Alumno alumnoTratado;

	@GetMapping(value = "/alls")
	public List<Alumno> buscoTodosAlumnos() {
		return alumnoService.buscaAllAlumnos();
	}

	@GetMapping(value = "/id/{id}")
	public Optional<Alumno> buscoPorId(@PathVariable Long id) {
		Optional<Alumno> alumnoId;
		alumnoId = alumnoService.buscoAlumnoId(id);

		return alumnoId;
	}

	@GetMapping(value = "/dni/{dni}")
	public Alumno buscoPorDni(@PathVariable String dni) {

		alumnoTratado = alumnoService.buscaDniAlumno(dni);

		return alumnoTratado;
	}

	@GetMapping(value = "/numMatricula/{numeroM}")
	public Alumno buscoPormMatricula(@PathVariable String numeroM) {

		alumnoTratado = alumnoService.buscaMatriculaAlumno(numeroM);

		return alumnoTratado;
	}

	@PostMapping(value = "/new",consumes = MediaType.APPLICATION_JSON_VALUE )
	public Alumno nuevoAlumno(@RequestBody Alumno alumno) {

		// Insertamos los datos del alumno
		alumnoTratado = alumnoService.nuevoAlumno(alumno);

		return alumnoTratado;
	}

	@DeleteMapping(value = "/borra/{id}")
	public List<Alumno> borroAlumno(@PathVariable Long id) {

		List<Alumno> alumnos = new ArrayList<>();

		alumnoService.borraAlumno(id);

		alumnos = alumnoService.buscaAllAlumnos();

		return alumnos;
	}

	@PutMapping(value = "/act/{id}")
	public Alumno ActualizoAlumno(@PathVariable Long id) {
		Optional<Alumno> alumnoAux;

		alumnoAux = alumnoService.buscoAlumnoId(id);

		alumnoTratado = alumnoService.nuevoAlumno(alumnoAux.get()); // Con el .get optenemos el valor del optional

		return alumnoTratado;

	}
	
	@PostMapping("/{curso}/{alumno}/{asignatura}")
	public void joinAlumnoAsignatura(@PathVariable String curso, @PathVariable Long alumno, @PathVariable ArrayList<Long> asignatura) {
		 //ArrayList<Long> idAsigAux = new ArrayList<Long>();
		System.out.println("Entro en joinAlumnoAsignatura");
		//Busco el objeto alumno que corresponde al ID enviado
		 Optional<Alumno> alumnoId = alumnoService.buscoAlumnoId(alumno);
		 
		// Busco los id's de cada una de las asignaturas que me llegan y voy haciendo la inserccion en la tabla por cada una de ellas
		 for (int i = 0; i < asignatura.size(); i++) {
			 Asignatura asignaturaAux = asignaturaService.buscoAsignaturaPorId(asignatura.get(i));
			 alumnoAsignatura.nuevaRelacion(curso, alumnoId, asignaturaAux);
		 }
	}
}
