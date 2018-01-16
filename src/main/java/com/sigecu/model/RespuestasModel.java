/**
 * 
 */
package com.sigecu.model;

import java.util.ArrayList;
import java.util.List;

import com.sigecu.entity.Preguntas;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 19/12/2017
 *
 */
public class RespuestasModel {

	/**
	 * 
	 */
	private int idRespuesta;
	private String rRespuesta;
	private String rSolucion;
	private Preguntas pregunta;
	private List<RespuestaALMModel> respuestaALMModel = new ArrayList<>();

	public RespuestasModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idRespuesta
	 * @param rRespuesta
	 * @param rSolucion
	 * @param pregunta
	 * @param respuestaALMModel
	 */
	public RespuestasModel(int idRespuesta, String rRespuesta, String rSolucion, Preguntas pregunta,
			List<RespuestaALMModel> respuestaALMModel) {
		super();
		this.idRespuesta = idRespuesta;
		this.rRespuesta = rRespuesta;
		this.rSolucion = rSolucion;
		this.pregunta = pregunta;
		this.respuestaALMModel = respuestaALMModel;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RespuestasModel [idRespuesta=" + idRespuesta + ", rRespuesta=" + rRespuesta + ", rSolucion=" + rSolucion
				+ ", pregunta=" + pregunta + ", respuestaALMModel=" + respuestaALMModel + "]";
	}

	/**
	 * @return the idRespuesta
	 */
	public int getIdRespuesta() {
		return idRespuesta;
	}

	/**
	 * @param idRespuesta
	 *            the idRespuesta to set
	 */
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	/**
	 * @return the rRespuesta
	 */
	public String getrRespuesta() {
		return rRespuesta;
	}

	/**
	 * @param rRespuesta
	 *            the rRespuesta to set
	 */
	public void setrRespuesta(String rRespuesta) {
		this.rRespuesta = rRespuesta;
	}

	/**
	 * @return the rSolucion
	 */
	public String getrSolucion() {
		return rSolucion;
	}

	/**
	 * @param rSolucion
	 *            the rSolucion to set
	 */
	public void setrSolucion(String rSolucion) {
		this.rSolucion = rSolucion;
	}

	/**
	 * @return the pregunta
	 */
	public Preguntas getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta
	 *            the pregunta to set
	 */
	public void setPregunta(Preguntas pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the respuestaALMModel
	 */
	public List<RespuestaALMModel> getRespuestaALMModel() {
		return respuestaALMModel;
	}

	/**
	 * @param respuestaALMModel the respuestaALMModel to set
	 */
	public void setRespuestaALMModel(List<RespuestaALMModel> respuestaALMModel) {
		this.respuestaALMModel = respuestaALMModel;
	}
	
}
