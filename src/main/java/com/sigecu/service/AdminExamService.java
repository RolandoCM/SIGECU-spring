package com.sigecu.service;

import java.util.List;

import com.sigecu.exception.BusinessException;
import com.sigecu.model.CursoModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.PreguntasModel;
import com.sigecu.model.RespuestasModel;

public interface AdminExamService {
	public abstract List<EvaluacionesModel> listAllEvaluaciones(int idCurso) throws BusinessException;
	public abstract List<CursoModel> listaCursos() throws BusinessException;

	public abstract void nuevaEvaluacion(EvaluacionesModel evalModel, int idCurso) throws BusinessException;

	public abstract List<PreguntasModel> listarPregunrasByExam(int idExamen) throws BusinessException;

	public abstract void nuevaPregunta(PreguntasModel preguntaModel, int idEvaluacion) throws BusinessException;

	// public abstract List<RespuestasModel> listaRespuestasModel(int )
	public abstract void nuevaRespuesta(RespuestasModel respuestasModel, int idPregunta) throws BusinessException;

	public abstract List<RespuestasModel> listarRespuestas() throws BusinessException;

	public abstract void eliminaPregunta(int idPregunta) throws BusinessException;

	public abstract void eliminarRespuesta(int idRespuesta) throws BusinessException;
	public abstract void eliminarExamen(int idExamen) throws BusinessException;

}
