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
@Repository("queryCalificacion")
public class QueryCalificacion {
	private static final Log LOG = LogFactory.getLog(QueryCalificacion.class);
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

	//preguntas correctas para el alumno
	public List<Preguntas> aciertos(int idEvaluacion, int idAsignaExamen){
		JPAQuery<Preguntas> query = new JPAQuery<>(em);
		List<Preguntas> listaPreguntas = query.select(qPreguntas)
				.from(qPreguntas, qALM, qRespuestas, qAsignaExamen)
				.where(qRespuestas.rSolucion.eq("1")
						.and(qALM.idRespuesta.eq(qRespuestas.idRespuesta))
						.and(qALM.idPregunta.eq(qPreguntas.idPregunta))
						.and(qAsignaExamen.idasignaExamen.eq(idAsignaExamen))
						.and(qAsignaExamen.idasignaExamen.eq(qALM.asignaExamen.idasignaExamen))
						)
				.fetch();
		return listaPreguntas;
				
		
	}
	
	
}
