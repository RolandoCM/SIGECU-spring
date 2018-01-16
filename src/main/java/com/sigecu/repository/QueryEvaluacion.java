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
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sigecu.entity.Evaluaciones;
import com.sigecu.entity.Preguntas;
import com.sigecu.entity.QAsignaExamenEntity;
import com.sigecu.entity.QCursos;
import com.sigecu.entity.QEvaluaciones;
import com.sigecu.entity.QPreguntas;
import com.sigecu.entity.QRespuestaALMEntity;
import com.sigecu.entity.QRespuestas;
import com.sigecu.entity.Respuestas;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 16/12/2017
 *
 */
@Repository("queryEvaluacion")
public class QueryEvaluacion {
	private static final Log LOG = LogFactory.getLog(QueryEvaluacion.class);
	QEvaluaciones qEval = QEvaluaciones.evaluaciones;
	QCursos qCursos = QCursos.cursos;
	QPreguntas qPreguntas = QPreguntas.preguntas;
	QRespuestas qRespuestas = QRespuestas.respuestas;
	QRespuestaALMEntity qALM= QRespuestaALMEntity.respuestaALMEntity;
	QAsignaExamenEntity qAsignaExamen = QAsignaExamenEntity.asignaExamenEntity;
	//persistencia de la app
	@PersistenceContext
	private EntityManager em;
	JPAQueryFactory queryFactory = null;
	
	/*Busca los examenes por id relacionados con el curso*/
	public List<Evaluaciones> findAllExamenesById(int idCurso) {
		
		 JPAQuery<Evaluaciones> query = new JPAQuery<>(em);
		 List<Evaluaciones> eval = query.select(qEval)
		 .from(qEval)
		 .where(qEval.cursos.idCurso.eq(idCurso))
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
	/*Busca respuestas de pregunta*/
	public List<Respuestas> findAllRespuestasByIdPregunta(int idPregunta){
		JPAQuery<Respuestas> query = new JPAQuery<> (em);
		List<Respuestas> listRespuestas = query.select(qRespuestas)
				.from(qRespuestas)
				.where(qRespuestas.preguntas.idPregunta.eq(idPregunta)).orderBy(qRespuestas.idRespuesta.desc())
				.fetch();
		return listRespuestas;
		
	}

	//si esta contertada regresa lista de preguntas
	public List<Preguntas> findPreguntas(int idEvaluacion, int idAsignaExamen){
		JPAQuery<Preguntas> query = new JPAQuery<> (em);
		List<Preguntas> listaPreguntas = query.select(qPreguntas)
				.from(qPreguntas, qALM, qEval, qRespuestas, qAsignaExamen)
				.where(qRespuestas.idRespuesta.eq(qALM.idRespuesta)
						.and(qPreguntas.idPregunta.eq(qALM.idPregunta))
						.and(qEval.idEvaluacion.eq(idEvaluacion))
						.and(qAsignaExamen.idasignaExamen.eq(idAsignaExamen))
						.and(qAsignaExamen.idasignaExamen.eq(qALM.asignaExamen.idasignaExamen))
						.and(qALM.seleccionada.eq("1")))
				.fetch();
		return listaPreguntas;
				
		
	}
	
	
	
	/*
	 * * preguntas erradas para retroalimentacion
	 */
	public List<Preguntas> findPreguntasErradasRetro(int idEvaluacion, int idAsignaExamen){
		JPAQuery<Preguntas> query = new JPAQuery<>(em);
		List<Preguntas> listPreguntas = query.select(qPreguntas)
				.from(qPreguntas, qALM, qRespuestas, qAsignaExamen)
				.where(qRespuestas.rSolucion.eq("0")
						.and(qALM.idRespuesta.eq(qRespuestas.idRespuesta))
						.and(qALM.idPregunta.eq(qPreguntas.idPregunta))
						.and(qAsignaExamen.idasignaExamen.eq(idAsignaExamen))
						.and(qAsignaExamen.idasignaExamen.eq(qALM.asignaExamen.idasignaExamen))
						)
				.fetch();
		
		return listPreguntas;
	}

	
	
}
