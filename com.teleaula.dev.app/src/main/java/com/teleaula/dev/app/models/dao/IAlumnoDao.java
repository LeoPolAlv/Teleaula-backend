package com.teleaula.dev.app.models.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teleaula.dev.app.models.entity.Alumno;

@Repository
public interface IAlumnoDao extends JpaRepository<Alumno, Long>{
	
	/* Metodos de busqueda */
	/*public List<Alumno> buscarAll();*/
	
	public Optional<Alumno> findById(Long id);
	
	@Query("select a from Alumno a where dni = ?1")
	public Alumno findByDni(String dni);

	/*public Alumno findByNombreAndApellidos(String nombre,String apellidos);
	
	public List<Alumno> findByFechaMatricula(Date fechaM);*/
	
	@Query("select a from Alumno a where numero_matricula = ?1")
	public Alumno findByNumeroMatricula(String numMatricula);
	
	/*
	 * Metodo para insertar o actualizar una entidad Alumno en la BD
	 */
	
	/*public void guardoAlumno(Alumno alumno);
	
	/*
	 * Metodo para eliminar una entidad Alumno
	 */
	
	/*public void borroAlumno(Alumno alumno);*/
}
