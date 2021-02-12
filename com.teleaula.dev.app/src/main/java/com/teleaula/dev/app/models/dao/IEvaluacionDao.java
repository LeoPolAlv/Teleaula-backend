package com.teleaula.dev.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teleaula.dev.app.models.entity.Evaluacion;


@Repository
public interface IEvaluacionDao extends JpaRepository<Evaluacion, Long> {

}
