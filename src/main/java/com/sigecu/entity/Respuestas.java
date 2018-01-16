/**
 * 
 */
package com.sigecu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rolando Castillo 14/12/2017
 *
 */
@Entity
@Table(name = "respuestas")
public class Respuestas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRespuesta")
	private int idRespuesta;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "preguntas_id_pregunta")
	private Preguntas preguntas;
	@Column(name = "rRespuesta")
	private String rRespuesta;
	@Column(name = "rSolucion")
	private String rSolucion;
	
	//@OneToMany(fetch=FetchType.EAGER, mappedBy="respuestas")
	//private Set<RespuestaALMEntity> respuestasAML = new HashSet<>();
	public Respuestas() {
		// TODO Auto-generated constructor stub
	}

	public Respuestas(int idRespuesta, String rRespuesta, String rSolucion) {
		// TODO Auto-generated constructor stub
		this.idRespuesta = idRespuesta;
		this.rRespuesta = rRespuesta;
		this.rSolucion = rSolucion;
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
	 * @return the preguntas
	 */
	public Preguntas getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas
	 *            the preguntas to set
	 */
	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
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

//	/**
//	 * @return the respuestasAML
//	 */
//	public Set<RespuestaALMEntity> getRespuestasAML() {
//		return respuestasAML;
//	}
//
//	/**
//	 * @param respuestasAML the respuestasAML to set
//	 */
//	public void setRespuestasAML(Set<RespuestaALMEntity> respuestasAML) {
//		this.respuestasAML = respuestasAML;
//	}

}
