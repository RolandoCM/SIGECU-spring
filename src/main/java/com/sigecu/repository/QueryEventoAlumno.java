package com.sigecu.repository;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sigecu.entity.AsignaExamenEntity;
import com.sigecu.entity.Cursos;
import com.sigecu.entity.Eventos;
import com.sigecu.entity.QAlumno;
import com.sigecu.entity.QAlumnoEventosId;
import com.sigecu.entity.QAlumno_Has_Eventos;
import com.sigecu.entity.QAsignaExamenEntity;
import com.sigecu.entity.QCursos;
import com.sigecu.entity.QEventos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;

@Repository("queryEventoAlumno")
public class QueryEventoAlumno {
	private static final Log LOG=LogFactory.getLog(QueryEventoAlumno.class);
	
	//Tablas a utilizar
	QAlumno qAlumno=QAlumno.alumno;
	QAlumno_Has_Eventos qAhE=QAlumno_Has_Eventos.alumno_Has_Eventos;
	QAlumnoEventosId qAEId=QAlumnoEventosId.alumnoEventosId;	
	QCursos qCursos=QCursos.cursos;
	QEventos qEventos=QEventos.eventos;
	QAsignaExamenEntity qAsignaExamenEntity = QAsignaExamenEntity.asignaExamenEntity;
	
	
	@PersistenceContext
	private EntityManager em;
	JPAQueryFactory queryFactory=null;
	
	//Busca los eventos relacionado por el ID del Alumno
   public List<Eventos> findAllEventosAlumnosById(int idAlumno){
	   JPAQuery<Eventos> query=new JPAQuery<> (em);
	   List<Eventos> listaEventos=query.select(qEventos)
			   .from(qEventos, qAhE, qAlumno)
			   .where(qEventos.idEvento.eq(qAhE.primaryKey.eventos.idEvento).
					   and(qAhE.primaryKey.alumno.idAlumno.eq(idAlumno)))
			   .distinct()
			   .fetch();
	   
	   return listaEventos;
	   
   }
   public Eventos findAllEventosByID(int idEvento){
	   JPAQuery<Eventos> query = new JPAQuery<>(em);
	   Eventos evento = query.select(qEventos)
			   .from(qEventos)
			   .where(qEventos.idEvento.eq(idEvento))
			   .fetchOne();
	   return evento;
	   
   }
   public AsignaExamenEntity validarCertificado(int idEvento, int idAlumno){
	   JPAQuery<AsignaExamenEntity> query = new JPAQuery<>(em);
	   AsignaExamenEntity v = query.select(qAsignaExamenEntity)
			   .from(qAsignaExamenEntity,qAhE)
			   .where(qAhE.primaryKey.eventos.idEvento.eq(idEvento)
					   .and(qAhE.primaryKey.alumno.idAlumno.eq(idAlumno))
					   .and(qAhE.asignaExamen.idasignaExamen.eq(qAsignaExamenEntity.idasignaExamen)))
			   .fetchOne();
	   
	   return v;
   }
  
	
	

}
