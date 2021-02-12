package com.teleaula.dev.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.teleaula.dev.app.models.entity.Asignatura;
import com.teleaula.dev.app.models.entity.Ciclo;
import com.teleaula.dev.app.service.IAsignaturaService;

@RestController
@RequestMapping(value = "/asignatura")
@SessionAttributes("asignatura")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
public class AsignturaController {
	
	@Autowired
	private IAsignaturaService asignaturaService;
	
	
	@PostMapping("/new")
	public Asignatura crearNueva(@RequestBody Asignatura asignatura) {
		
		return asignaturaService.nuevaAsignatura(asignatura);
	}
	
	@GetMapping(value = "/find/all")
	public List<Asignatura> buscoTodasAsignaturas(){
		
		return asignaturaService.buscoAsignaturas();
	}
	
	@GetMapping(value = "/find/{id}")
	public Asignatura buscoAsignatura(@PathVariable Long id) {
		
		return asignaturaService.buscoAsignaturaPorId(id);
	}
	
	@GetMapping(value = "/find/{ciclo}/{curso}")
	public List<Asignatura> buscoPorCicloCurso(@PathVariable Ciclo ciclo, @PathVariable String curso){
		return asignaturaService.buscoAsignaturaPorCicloCurso(ciclo, curso);
	}
	
}
