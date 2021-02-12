package com.teleaula.dev.app.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teleaula.dev.app.models.entity.Asignatura;
import com.teleaula.dev.app.models.entity.Ciclo;
import com.teleaula.dev.app.models.entity.TipoAsignatura;

@Repository
public interface IAsignaturaDao extends JpaRepository<Asignatura, Long> {
	
	@Query("select asg from Asignatura asg where nombre = ?1")
	public Optional<Asignatura> buscarPorNombre(String nombre);
	
	@Query("select asg from Asignatura asg where ciclo = ?1 and curso = ?2")
	public List<Asignatura> buscoPorCicloCurso(Ciclo ciclo, String curso);
	
	@Query("select asg from Asignatura asg where tipo = ?1")
	public List<Asignatura> buscoPorTipo(TipoAsignatura tipo);

	
}
