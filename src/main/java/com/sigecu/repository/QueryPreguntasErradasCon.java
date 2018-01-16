/**
 * 
 */
package com.sigecu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;


import com.querydsl.jpa.impl.JPAQuery;
import com.sigecu.entity.Evaluaciones;
import com.sigecu.entity.Preguntas;
import com.sigecu.entity.QAsignaExamenEntity;
import com.sigecu.entity.QEvaluaciones;
import com.sigecu.entity.QPreguntas;
import com.sigecu.entity.QRespuestaALMEntity;
import com.sigecu.entity.QRespuestas;

/**
 * @author Dell
 *
 */
@Repository("queryPreguntaErradaRepository")
public class QueryPreguntasErradasCon {
	
	private static final Log LOG = LogFactory.getLog(QueryPreguntasErradasCon.class);
	private QEvaluaciones qEvaluaciones = QEvaluaciones.evaluaciones;
	private QPreguntas qPreguntas = QPreguntas.preguntas;
	private QRespuestas qRespuestas = QRespuestas.respuestas;
	private QRespuestaALMEntity qALM = QRespuestaALMEntity.respuestaALMEntity;
	private QAsignaExamenEntity qAsignaExamen = QAsignaExamenEntity.asignaExamenEntity;
	
	@PersistenceContext
    private EntityManager em;
	
	/*Busca los examenes por id relacionados con el curso*/
	public List<Evaluaciones> findAllExamenesById(int idCurso) {
		
		 JPAQuery<Evaluaciones> query = new JPAQuery<>(em);
		 List<Evaluaciones> eval = query.select(qEvaluaciones)
		 .from(qEvaluaciones)
		 .where(qEvaluaciones.cursos.idCurso.eq(idCurso))
		 .fetch();
		 LOG.info("LISTA DE EXAMENES POR CURSO");
		 
		 return eval;
	}
	/*Busca preguntas por id de examen*/
	public List<Preguntas> findAllPreguntasById(int idExamen){
		JPAQuery<Preguntas> query = new JPAQuery<> (em);
		List<Preguntas> listPreguntas = query.select(qPreguntas)
				.from(qPreguntas)
				.where(qPreguntas.evaluaciones.idEvaluacion.eq(idExamen))
				.orderBy(qPreguntas.idPregunta.desc())
				.fetch();
		return listPreguntas;
		
	}
	
	/*
	 * Agregar preguntas erradas*/
	public List<Preguntas> findPreguntasErradas(int idEvaluacion, int idAsignaExamen){
		JPAQuery<Preguntas> query = new JPAQuery<>(em);
		List<Preguntas> listPreguntas = query.select(qPreguntas)
				.from(qPreguntas, qALM, qRespuestas, qAsignaExamen)
				.where(qRespuestas.rSolucion.eq("0")
						.and(qALM.seleccionada.eq("1"))
						.and(qALM.idRespuesta.eq(qRespuestas.idRespuesta))
						.and(qALM.idPregunta.eq(qPreguntas.idPregunta))
						.and(qAsignaExamen.idasignaExamen.eq(idAsignaExamen))
						.and(qAsignaExamen.idasignaExamen.eq(qALM.asignaExamen.idasignaExamen))
						)
				.fetch();
		
		return listPreguntas;
	}
	


}
