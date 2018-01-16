/**
 * 
 */
package com.sigecu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sigecu.entity.Evaluaciones;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 18/12/2017
 *
 */
public class PreguntasModel {

	/**
	 * 
	 */
	private int idPregunta;
	private String pPregunta;
	private String pDescripcion;
	private Evaluaciones evaluacion;
	private String puntaje;
	private List<RespuestasModel> respuestasModel = new ArrayList<>();

	public PreguntasModel() {
	}

	public String toString() {
		return "idPregunta: " + idPregunta + " pPregunta " + pPregunta + " pDescripcion: " + pDescripcion;
	}

	/**
	 * @return the puntaje
	 */
	public String getPuntaje() {
		return puntaje;
	}

	/**
	 * @param puntaje
	 *            the puntaje to set
	 */
	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}

	/**
	 * @return the idPregunta
	 */
	public int getIdPregunta() {
		return idPregunta;
	}

	/**
	 * @param idPregunra
	 *            the idPregunta to set
	 */
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	/**
	 * @return the pPregunta
	 */
	public String getpPregunta() {
		return pPregunta;
	}

	/**
	 * @param pPregunta
	 *            the pPregunta to set
	 */
	public void setpPregunta(String pPregunta) {
		this.pPregunta = pPregunta;
	}

	/**
	 * @return the pDescripcion
	 */
	public String getpDescripcion() {
		return pDescripcion;
	}

	/**
	 * @param pDescripcion
	 *            the pDescripcion to set
	 */
	public void setpDescripcion(String pDescripcion) {
		this.pDescripcion = pDescripcion;
	}

	/**
	 * @return the evaluacion
	 */
	public Evaluaciones getEvaluacion() {
		return evaluacion;
	}

	/**
	 * @param evaluacion
	 *            the evaluacion to set
	 */
	public void setEvaluacion(Evaluaciones evaluacion) {
		this.evaluacion = evaluacion;
	}

	/**
	 * @return the respuestasModel
	 */
	public List<RespuestasModel> getRespuestasModel() {
		return respuestasModel;
	}

	/**
	 * @param respuestasModel the respuestasModel to set
	 */
	public void setRespuestasModel(List<RespuestasModel> respuestasModel) {
		this.respuestasModel = respuestasModel;
	}
	

}
