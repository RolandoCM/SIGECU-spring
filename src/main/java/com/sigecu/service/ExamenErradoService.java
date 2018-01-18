package com.sigecu.service;

import java.util.List;

import com.sigecu.exception.BusinessException;
import com.sigecu.model.PreguntasModel;

/**
 * @author Anel
 *
 */
public interface ExamenErradoService {
	public abstract List<PreguntasModel> listarPreguntasByExamErrado(int idExamen , int idAsignaExamen) throws BusinessException;
	public abstract void guardarRespuestas (int idRespuesta, int idAsignaExamen, int idPregunta) throws BusinessException;
	public abstract void marcarExamenRealizado(int idAsignaExamen) throws BusinessException;
	// public abstract void nuevaRespuesta(RespuestasModel respuestasModel, int idPregunta);

}
