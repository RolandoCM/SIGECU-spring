package com.sigecu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Cursos {
	@Id
	@GeneratedValue
	@Column(name="idCurso")
	private int idCurso;
	@Column(name="cNombre", unique=true, nullable=false, length=45)
	private String cNombre;
	@Column(name="cDescripcion")
	private String cDescripcion;
	@OneToMany(fetch =  FetchType.EAGER, mappedBy="cursos")
	private Set<Evaluaciones> evaluaciones = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy="cursosEvento")
	private Set<Eventos> eventos = new HashSet<>();
	
//	@OneToMany(mappedBy = "cursos")
//	private List<Evaluaciones> evaluaciones = new ArrayList<>();
	
	/**
	 * @return the cNombre
	 */
	public String getcNombre() {
		return cNombre;
	}
	/**
	 * @param cNombre the cNombre to set
	 */
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	/**
	 * @return the cDescripcion
	 */
	public String getcDescripcion() {
		return cDescripcion;
	}
	/**
	 * @param cDescripcion the cDescripcion to set
	 */
	public void setcDescripcion(String cDescripcion) {
		this.cDescripcion = cDescripcion;
	}
	/**
	 * @return the idCurso
	 */
	public int getIdCurso() {
		return idCurso;
	}
	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	/**
	 * @return the evaluaciones
	 */
	public Set<Evaluaciones> getEvaluaciones() {
		return evaluaciones;
	}
	/**
	 * @param evaluaciones the evaluaciones to set
	 */
	public void setEvaluaciones(Set<Evaluaciones> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	/**
	 * @return the eventos
	 */
	public Set<Eventos> getEventos() {
		return eventos;
	}
	/**
	 * @param eventos the eventos to set
	 */
	public void setEventos(Set<Eventos> eventos) {
		this.eventos = eventos;
	}
	
	
	

}
