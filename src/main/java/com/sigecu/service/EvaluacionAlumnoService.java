package com.sigecu.service;

import java.util.List;

import com.sigecu.model.PreguntasModel;

public interface EvaluacionAlumnoService {
	
	public abstract List<PreguntasModel> listarPreguntasByEvaluacion(int idEvaluacion, int idAsignaExamen);
	
	public abstract void guardarRespuestas (int idRespuesta, int idAsignaExamen, int idPregunta);
	
	public abstract void marcarExamenRealizado(int idAsignaExamen);

	public abstract String tiempoExamen(int idEvaluacion);
	public abstract String horaInicio(int idEvaluacion);
	
	public abstract String horaFin(int idEvaluacion);
}
