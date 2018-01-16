/**
 * 
 */
package com.sigecu.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 02/01/2018
 *
 */
@Embeddable
public class AlumnoEventosId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Alumno alumno;
	
	
	private Eventos eventos;
	/**
	 * @return the alumno
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	public Alumno getAlumno() {
		return alumno;
	}
	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	/**
	 * @return the evntos
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	public Eventos getEventos() {
		return eventos;
	}
	/**
	 * @param evntos the evntos to set
	 */
	public void setEventos(Eventos eventos) {
		this.eventos = eventos;
	}
	
	
}
