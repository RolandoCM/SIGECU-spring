package com.sigecu.service;

import java.util.List;
import com.sigecu.model.PreguntasModel;

/**
 * @author Anel
 *
 */
public interface ExamenErradoService {
	public abstract List<PreguntasModel> listarPreguntasByExamErrado(int idExamen , int idAsignaExamen);
	public abstract void guardarRespuestas (int idRespuesta, int idAsignaExamen, int idPregunta);
	public abstract void marcarExamenRealizado(int idAsignaExamen);
	// public abstract void nuevaRespuesta(RespuestasModel respuestasModel, int idPregunta);

}
