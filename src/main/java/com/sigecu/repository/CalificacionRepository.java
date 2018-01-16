package com.sigecu.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.sigecu.entity.RespuestaALMEntity;

@Repository("calificacionRepository")
public interface CalificacionRepository extends JpaRepository <RespuestaALMEntity,String>  {
	//extends JpaRepository <RespuestaALMEntity, Serializable>
	/*public abstract RespuestaALMEntity findByidrespuestaALM(int idrespuestaALM);
	//SELECT e.id_evaluacion, e.e_nombre, e.e_porsentaje, e.e_tiempo, c.c_nombre FROM evaluaciones e, cursos c WHERE c.id_curso=e.cursos_id_curso
	@Query(value="SELECT count(rm.idrespuestaalm) as seleccionada FROM respuestaalm rm, respuestas r WHERE rm.seleccionada = r.r_solucion", nativeQuery=true)
	//@Query(value="SELECT e.id_evaluacion, e.e_nombre, e.e_porcentaje, e.e_tiempo, c.c_nombre FROM evaluaciones e, cursos c WHERE c.id_curso=e.id_curso", nativeQuery=true)
	//@Query(value="SELECT p FROM evaluaciones p WHERE e_nombre='ok'")
	public abstract  List<RespuestaALMEntity> findT_Respuestas();*/
	
	@Query(value="SELECT count(rm.idrespuestaalm) FROM respuestaalm rm, respuestas r WHERE rm.seleccionada = r.r_solucion and rm.idrespuestaalm =r.id_respuesta", nativeQuery=true)
	String aciertos();
	
	
	 @Query(value="select count(idrespuestaalm) - (SELECT count(rm.idrespuestaalm) FROM respuestaalm rm, respuestas r WHERE rm.seleccionada = r.r_solucion and rm.idrespuestaalm =r.id_respuesta) from respuestaalm", nativeQuery=true)
	 String erroneas();
	 
	 String consulta="select (select sum(p_puntaje) from preguntas where id_pregunta in (SELECT r.preguntas_id_pregunta FROM respuestaalm rm, respuestas r WHERE rm.seleccionada = r.r_solucion and rm.idrespuestaalm =r.id_respuesta)) / sum(p_puntaje) *100 from preguntas";
	 @Query(value=consulta, nativeQuery=true)
	 String calificacion();
	
	
}
