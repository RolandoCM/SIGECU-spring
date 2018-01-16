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
@Table(name = "preguntas")
public class Preguntas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPregunta")
	private int idPregunta;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "evaluaciones_id_evaluacion")
	private Evaluaciones evaluaciones;
	@Column(name = "pPregunta")
	private String pPregunta;
	@Column(name = "pDescripcion")
	private String pDescripcion;
	@Column(name = "pPuntaje")
	private String pPuntaje;
	@OneToMany(fetch= FetchType.EAGER, mappedBy="preguntas")
	private Set<Respuestas> respuestas = new HashSet<>();

	public Preguntas() {
		// TODO Auto-generated constructor stub
	}

	public Preguntas(int idPregunta, String pPregunta, String pDescripcion, String pPuntaje) {
		this.idPregunta = idPregunta;
		this.pPregunta = pPregunta;
		this.pDescripcion = pDescripcion;
		this.pPuntaje = pPuntaje;
	}

	/**
	 * @return the idPregunta
	 */
	public int getIdPregunta() {
		return idPregunta;
	}

	/**
	 * @param idPregunta
	 *            the idPregunta to set
	 */
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	/**
	 * @return the evaluaciones
	 */
	public Evaluaciones getEvaluaciones() {
		return evaluaciones;
	}

	/**
	 * @param evaluaciones
	 *            the evaluaciones to set
	 */
	public void setEvaluaciones(Evaluaciones evaluaciones) {
		this.evaluaciones = evaluaciones;
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
	 * @return the pPuntaje
	 */
	public String getpPuntaje() {
		return pPuntaje;
	}

	/**
	 * @param pPuntaje
	 *            the pPuntaje to set
	 */
	public void setpPuntaje(String pPuntaje) {
		this.pPuntaje = pPuntaje;
	}

	/**
	 * @return the respuestas
	 */
	public Set<Respuestas> getRespuestas() {
		return respuestas;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(Set<Respuestas> respuestas) {
		this.respuestas = respuestas;
	}
	

}
