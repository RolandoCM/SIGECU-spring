package com.sigecu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sigecu.entity.Alumno_Has_Eventos;
import com.sigecu.entity.QAlumno;
import com.sigecu.entity.QAlumno_Has_Eventos;
import com.sigecu.entity.QAsignaExamenEntity;
import com.sigecu.entity.QCursos;
import com.sigecu.entity.QEventos;
import com.sigecu.exception.BusinessException;

@Repository("queryAlumnoHasEvento")
public class QueryAlumnoHasEvento {
	private static final Log LOG = LogFactory.getLog(QueryAlumnoHasEvento.class);
	QAlumno_Has_Eventos qAlumno_Has_Eventos = QAlumno_Has_Eventos.alumno_Has_Eventos;
	QCursos qCursos = QCursos.cursos;
	QAlumno qAlumno = QAlumno.alumno;
	QAsignaExamenEntity qAsignaExamen = QAsignaExamenEntity.asignaExamenEntity;
	QEventos qEventos = QEventos.eventos;
	//persistencia de la app
	@PersistenceContext
	private EntityManager em;
	JPAQueryFactory queryFactory = null;
	
	//Buscar los el evento en relación con el alumnoHasEvento
	public Tuple findAlumnoHasEventosByIdAlumnoAndIdEvento(int id_alumno, int id_evento) {
		JPAQuery<Alumno_Has_Eventos> query = new JPAQuery<>(em);
		
		Tuple AHE = query.select(qAlumno.aNombre, qAlumno.aPaterno, qAlumno.aMaterno, qCursos.cNombre,  qEventos.eFechaTermino)
				.from(qAlumno_Has_Eventos, qCursos, qAlumno, qEventos)
				.where(qAlumno_Has_Eventos.primaryKey.alumno.idAlumno.eq(qAlumno.idAlumno)
						.and(qAlumno.idAlumno.eq(id_alumno)).and(qEventos.idEvento.eq(id_evento))
						.and(qAlumno_Has_Eventos.primaryKey.eventos.idEvento.eq(qEventos.idEvento)
								.and(qEventos.cursosEvento.idCurso.eq(qCursos.idCurso))))
				.fetchOne();
		return AHE;
	}
	
	
	//buscar AlumnoHasEvento 
	public Alumno_Has_Eventos findAlumnoHasEvento(int idAlumno, int idEvento) throws BusinessException {
		Alumno_Has_Eventos AHE=null;
		JPAQuery <Alumno_Has_Eventos> query = new JPAQuery<>(em);
		try {
			AHE = query.select(qAlumno_Has_Eventos)
					.from(qAlumno_Has_Eventos)
					.where(qAlumno_Has_Eventos.primaryKey.alumno.idAlumno.eq(idAlumno)
							.and(qAlumno_Has_Eventos.primaryKey.eventos.idEvento.eq(idEvento)))
					.fetchOne();
			return AHE;
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(00);
			be.setMsj("ERROR EN LA CAPA DE ACCESO A DATOS");
			LOG.info("Error en ejecutar la query");
			throw be;
		}
	}
	
}
