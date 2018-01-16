/**
 * 
 */
package com.sigecu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 03/01/2018
 *
 */
@Entity
@Table(name="eventos")
public class Eventos {
	
	private int idEvento;
	private String eDescripcion;
	private Cursos cursosEvento;
	private Instructor instructor;
	private String eFechaInicio;
	private String eFechaTermino;
	private String ePrograma;
	private String eHorario;
	private String eCapacidad;
	private String eTipo;
	private String eStatus;
	
	private Set<Alumno_Has_Eventos> alumnosHasEventos = new HashSet<>();
	
	public Eventos() {
		// TODO Auto-generated constructor stub
	}
	public void addAlumnosHasEventos(Alumno_Has_Eventos alm_has_event) {
		this.alumnosHasEventos.add(alm_has_event);
	}

	/**
	 * @return the id_evento
	 */
	@Id
	@GeneratedValue
	@Column(name="id_evento")
	public int getIdEvento() {
		return idEvento;
	}

	/**
	 * @param id_evento the id_evento to set
	 */
	public void setIdEvento(int id_evento) {
		this.idEvento = id_evento;
	}

	
	/**
	 * @return the cursosEvento
	 */
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="idCurso")
	public Cursos getCursosEvento() {
		return cursosEvento;
	}
	/**
	 * @param cursosEvento the cursosEvento to set
	 */
	public void setCursosEvento(Cursos cursosEvento) {
		this.cursosEvento = cursosEvento;
	}
	
	

	/**
	 * @return the instructor
	 */
	@ManyToOne
	@JoinColumn(name="idInstructor")
	public Instructor getInstructor() {
		return instructor;
	}
	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	/**
	 * @return the alumnos_has_eventos
	 */
	@OneToMany(mappedBy = "primaryKey.eventos", cascade = CascadeType.ALL)
	public Set<Alumno_Has_Eventos> getAlumnosHasEventos() {
		return alumnosHasEventos;
	}

	/**
	 * @param alumnos_has_eventos the alumnos_has_eventos to set
	 */
	public void setAlumnosHasEventos(Set<Alumno_Has_Eventos> alumnos_has_eventos) {
		this.alumnosHasEventos = alumnos_has_eventos;
	}
	/**
	 * @return the eDescripcion
	 */
	public String geteDescripcion() {
		return eDescripcion;
	}
	/**
	 * @param eDescripcion the eDescripcion to set
	 */
	public void seteDescripcion(String eDescripcion) {
		this.eDescripcion = eDescripcion;
	}
	/**
	 * @return the eFechaInicio
	 */
	public String geteFechaInicio() {
		return eFechaInicio;
	}
	/**
	 * @param eFechaInicio the eFechaInicio to set
	 */
	public void seteFechaInicio(String eFechaInicio) {
		this.eFechaInicio = eFechaInicio;
	}
	/**
	 * @return the eFechaTermino
	 */
	public String geteFechaTermino() {
		return eFechaTermino;
	}
	/**
	 * @param eFechaTermino the eFechaTermino to set
	 */
	public void seteFechaTermino(String eFechaTermino) {
		this.eFechaTermino = eFechaTermino;
	}
	/**
	 * @return the ePrograma
	 */
	public String getePrograma() {
		return ePrograma;
	}
	/**
	 * @param ePrograma the ePrograma to set
	 */
	public void setePrograma(String ePrograma) {
		this.ePrograma = ePrograma;
	}
	/**
	 * @return the eHorario
	 */
	public String geteHorario() {
		return eHorario;
	}
	/**
	 * @param eHorario the eHorario to set
	 */
	public void seteHorario(String eHorario) {
		this.eHorario = eHorario;
	}
	/**
	 * @return the eCapacidad
	 */
	public String geteCapacidad() {
		return eCapacidad;
	}
	/**
	 * @param eCapacidad the eCapacidad to set
	 */
	public void seteCapacidad(String eCapacidad) {
		this.eCapacidad = eCapacidad;
	}
	/**
	 * @return the eTipo
	 */
	public String geteTipo() {
		return eTipo;
	}
	/**
	 * @param eTipo the eTipo to set
	 */
	public void seteTipo(String eTipo) {
		this.eTipo = eTipo;
	}
	/**
	 * @return the eStatus
	 */
	public String geteStatus() {
		return eStatus;
	}
	/**
	 * @param eStatus the eStatus to set
	 */
	public void seteStatus(String eStatus) {
		this.eStatus = eStatus;
	}
	

}
