package com.sigecu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RespuestaALM")
public class RespuestaALMEntity {
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="idRespuestaALM",unique=true,nullable=false)
	private int idRespuestaALM;
	//@ManyToOne(fetch=FetchType.EAGER)
	//@JoinColumn(name="r_idRespuesta")
	//private Respuestas respuestas;
	@Column(name="seleccionada")
	private String seleccionada;
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="aIdAsignaExamen")
	private AsignaExamenEntity asignaExamen;
	@Column(name="idPregunta")
	private int idPregunta;
	@Column (name="idRespuesta")
	private int idRespuesta;
	
	
/**
	 * @return the idRespuestaALM
	 */
	public int getIdRespuestaALM() {
		return idRespuestaALM;
	}
	/**
	 * @param idRespuestaALM the idRespuestaALM to set
	 */
	public void setIdRespuestaALM(int idRespuestaALM) {
		this.idRespuestaALM = idRespuestaALM;
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
	 * @return the idRespuesta
	 */
	public int getIdRespuesta() {
		return idRespuesta;
	}
	/**
	 * @param idRespuesta the idRespuesta to set
	 */
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	//	/**
//	 * @return the respuestas
//	 */
//	public Respuestas getRespuestas() {
//		return respuestas;
//	}
//	/**
//	 * @param respuestas the respuestas to set
//	 */
//	public void setRespuestas(Respuestas respuestas) {
//		this.respuestas = respuestas;
//	}
//	/**
//	 * @return the seleccionada
//	 */
	public String getSeleccionada() {
		return seleccionada;
	}
	/**
	 * @param seleccionada the seleccionada to set
	 */
	public void setSeleccionada(String seleccionada) {
		this.seleccionada = seleccionada;
	}
	/**
	 * @return the asignaExamen
	 */
	public AsignaExamenEntity getAsignaExamen() {
		return asignaExamen;
	}
	/**
	 * @param asignaExamen the asignaExamen to set
	 */
	public void setAsignaExamen(AsignaExamenEntity asignaExamen) {
		this.asignaExamen = asignaExamen;
	}
	
	

}
