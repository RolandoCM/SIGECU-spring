/**
 * 
 */
package com.sigecu.service;

import java.util.List;

import com.sigecu.entity.Respuestas;

import com.sigecu.model.CursoModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.PreguntasModel;
import com.sigecu.model.PreguntasRetroModel;
import com.sigecu.model.RespuestaALMModel;
import com.sigecu.model.RespuestasModel;


/**
 * @author Dell
 *
 */
public interface PreguntasErradasConService {
	
	public abstract List<Respuestas> listarPreguntasHerradas();
	public abstract List<EvaluacionesModel> listarEvaluaciones(int idCurso);
	public abstract List<CursoModel> listaCursos();
	public abstract List<PreguntasRetroModel> listarPregunrasByExam(int idEvaluacion, int idAsignaExamen);
	public abstract List<RespuestasModel> listarRespuestas();
	public abstract List<RespuestaALMModel> listarRespuestasAlumno();
	


}
