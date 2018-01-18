package com.sigecu.service;

import java.util.List;

import com.sigecu.exception.BusinessException;
import com.sigecu.model.PreguntasModel;

public interface EvaluacionAlumnoService {
	
	public abstract List<PreguntasModel> listarPreguntasByEvaluacion(int idEvaluacion, int idAsignaExamen) throws BusinessException;
	
	public abstract void guardarRespuestas (int idRespuesta, int idAsignaExamen, int idPregunta) throws BusinessException;
	
	public abstract void marcarExamenRealizado(int idAsignaExamen) throws BusinessException;

	public abstract String tiempoExamen(int idEvaluacion) throws BusinessException;
	public abstract String horaInicio(int idEvaluacion) throws BusinessException;
	
	public abstract String horaFin(int idEvaluacion) throws BusinessException;
}
