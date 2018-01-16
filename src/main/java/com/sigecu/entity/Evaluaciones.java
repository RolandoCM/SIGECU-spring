package com.sigecu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * @author Rolando Castillo 
 * @contact castillomartinez@acm.org
 * */

@Entity
@Table(name = "evaluaciones")
public class Evaluaciones {
	@Id
	@GeneratedValue
	@Column(name = "idEvaluacion")
	private int idEvaluacion;
	@Column(name = "eNombre")
	private String eNombre;
	@Column(name = "eTiempo")
	private String eTiempo;
	@Column(name = "ePorsentaje")
	private String ePorsentaje;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cursos_id_curso")
	private Cursos cursos;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="evaluaciones")
	private Set<Preguntas> preguntas = new HashSet<>();

	public Evaluaciones() {

	}

	public Evaluaciones(int idEvaluacion, String eNombre, String eTiempo, String ePorsentaje) {
		this.idEvaluacion = idEvaluacion;
		this.eNombre = eNombre;
		this.eTiempo = eTiempo;
		this.ePorsentaje = ePorsentaje;

	}

	/**
	 * @return the idEvaluacion
	 */
	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	/**
	 * @param idEvaluacion
	 *            the idEvaluacion to set
	 */
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	/**
	 * @return the eNombre
	 */
	public String geteNombre() {
		return eNombre;
	}

	/**
	 * @param eNombre
	 *            the eNombre to set
	 */
	public void seteNombre(String eNombre) {
		this.eNombre = eNombre;
	}

	/**
	 * @return the eTiempo
	 */
	public String geteTiempo() {
		return eTiempo;
	}

	/**
	 * @param eTiempo
	 *            the eTiempo to set
	 */
	public void seteTiempo(String eTiempo) {
		this.eTiempo = eTiempo;
	}

	/**
	 * @return the ePorsentaje
	 */
	public String getePorsentaje() {
		return ePorsentaje;
	}

	/**
	 * @param ePorsentaje
	 *            the ePorsentaje to set
	 */
	public void setePorsentaje(String ePorsentaje) {
		this.ePorsentaje = ePorsentaje;
	}

	/**
	 * @return the cursos
	 */
	public Cursos getCursos() {
		return cursos;
	}

	/**
	 * @param cursos
	 *            the cursos to set
	 */
	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}

	/**
	 * @return the preguntas
	 */
	public Set<Preguntas> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(Set<Preguntas> preguntas) {
		this.preguntas = preguntas;
	}
	
}
