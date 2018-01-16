package com.sigecu.service;

import java.util.List;

import com.sigecu.model.CursoModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.PreguntasModel;
import com.sigecu.model.RespuestasModel;

public interface AdminExamService {
	public abstract List<EvaluacionesModel> listAllEvaluaciones(int idCurso);
	public abstract List<CursoModel> listaCursos();

	public abstract void nuevaEvaluacion(EvaluacionesModel evalModel, int idCurso);

	public abstract List<PreguntasModel> listarPregunrasByExam(int idExamen);

	public abstract void nuevaPregunta(PreguntasModel preguntaModel, int idEvaluacion);

	// public abstract List<RespuestasModel> listaRespuestasModel(int )
	public abstract void nuevaRespuesta(RespuestasModel respuestasModel, int idPregunta);

	public abstract List<RespuestasModel> listarRespuestas();

	public abstract void eliminaPregunta(int idPregunta);

	public abstract void eliminarRespuesta(int idRespuesta);
	public abstract void eliminarExamen(int idExamen);

}
