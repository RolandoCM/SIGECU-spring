/**
 * 
 */
package com.sigecu.service;

import java.util.List;

import com.sigecu.entity.Respuestas;
import com.sigecu.exception.BusinessException;
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
	
	public abstract List<Respuestas> listarPreguntasHerradas() throws BusinessException;
	public abstract List<EvaluacionesModel> listarEvaluaciones(int idCurso) throws BusinessException;
	public abstract List<CursoModel> listaCursos() throws BusinessException;
	public abstract List<PreguntasRetroModel> listarPregunrasByExam(int idEvaluacion, int idAsignaExamen) throws BusinessException;
	public abstract List<RespuestasModel> listarRespuestas() throws BusinessException;
	public abstract List<RespuestaALMModel> listarRespuestasAlumno() throws BusinessException;
	


}
