/**
 * 
 */
package com.sigecu.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 16/01/2018
 *
 */
public class PreguntasRetroModel {
	private int idPregunta;
	private String preguntaEnun;
	private int correcta;
	private String descripcion;
	private List<RespuestasModel> respuestasModel = new ArrayList<>();
	/**
	 * 
	 */
	public PreguntasRetroModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idPregunta
	 * @param preguntaEnun
	 * @param correta
	 * @param descripcion
	 * @param respuestasModel
	 */
	public PreguntasRetroModel(int idPregunta, String preguntaEnun, int correta, String descripcion,
			List<RespuestasModel> respuestasModel) {
		super();
		this.idPregunta = idPregunta;
		this.preguntaEnun = preguntaEnun;
		this.correcta = correta;
		this.descripcion = descripcion;
		this.respuestasModel = respuestasModel;
	}
	/**
	 * @return the idPregunta
	 */
	public int getIdPregunta() {
		return idPregunta;
	}
	/**
	 * @param idPregunta the idPregunta to set
	 */
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	/**
	 * @return the preguntaEnun
	 */
	public String getPreguntaEnun() {
		return preguntaEnun;
	}
	/**
	 * @param preguntaEnun the preguntaEnun to set
	 */
	public void setPreguntaEnun(String preguntaEnun) {
		this.preguntaEnun = preguntaEnun;
	}
	/**
	 * @return the correta
	 */
	public int getCorrecta() {
		return correcta;
	}
	/**
	 * @param correta the correta to set
	 */
	public void setCorrecta(int correta) {
		this.correcta = correta;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
