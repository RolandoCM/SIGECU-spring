/**
 * 
 */
package com.sigecu.repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.Cursos;
import com.sigecu.entity.Evaluaciones;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 14/12/2017
 *
 */
@Repository("evaluacionesRepository")
public interface EvaluacionRepository extends JpaRepository <Evaluaciones, Serializable> {
	//busca por idEvaluacion y regresa evaluacion
	
	public abstract Evaluaciones findByIdEvaluacion(int idEvaluacion);
	
	//SELECT e.id_evaluacion, e.e_nombre, e.e_porsentaje, e.e_tiempo, c.c_nombre FROM evaluaciones e, cursos c WHERE c.id_curso=e.cursos_id_curso
	@Query(value="SELECT e.id_evaluacion, e.e_nombre, e.e_porsentaje, e.e_tiempo, c.c_nombre FROM evaluaciones e, cursos c WHERE c.id_curso=e.cursos_id_curso", nativeQuery=true)
	//@Query(value="SELECT e.id_evaluacion, e.e_nombre, e.e_porcentaje, e.e_tiempo, c.c_nombre FROM evaluaciones e, cursos c WHERE c.id_curso=e.id_curso", nativeQuery=true)
	//@Query(value="SELECT p FROM evaluaciones p WHERE e_nombre='ok'")
	public abstract  List<Evaluaciones> findT();
	
	
	@Query(value="SELECT a.horafin FROM asigna_examen a, evaluaciones e where a.idasigna_examen = e.id_evaluacion",nativeQuery=true)
	String horaFin();
	
	@Query(value="SELECT a.hora_inicio FROM asigna_examen a, evaluaciones e where a.idasigna_examen = e.id_evaluacion",nativeQuery=true)
	String horaInicio();
	
}
