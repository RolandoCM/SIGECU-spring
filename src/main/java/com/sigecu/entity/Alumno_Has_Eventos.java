/**
 * 
 */
package com.sigecu.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 03/01/2018
 *
 */
@Entity
@Table(name="alumno_has_eventos")
@AssociationOverrides({
	@AssociationOverride (name="primaryKey.alumno",
			joinColumns = @JoinColumn(name= "id_alumno")),
	@AssociationOverride (name = "primaryKey.eventos",
	joinColumns = @JoinColumn(name="id_evento"))
})
public class Alumno_Has_Eventos {
	private AlumnoEventosId primaryKey = new AlumnoEventosId();
	private String confirmado;
	private int activo;

	
	private AsignaExamenEntity asignaExamen;
	
	public Alumno_Has_Eventos() {}
	/**
	 * @return the primaryKey
	 */
	@EmbeddedId
	public AlumnoEventosId getPrimaryKey() {
		return primaryKey;
	}
	/**
	 * @param primaryKey the primaryKey to set
	 */
	public void setPrimaryKey(AlumnoEventosId primaryKey) {
		this.primaryKey = primaryKey;
	}
	@Transient
	public Alumno getAlumno() {
		return getPrimaryKey().getAlumno();
	}
	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		getPrimaryKey().setAlumno(alumno);;
	}
	/**
	 * @return the evntos
	 */
	@Transient
	public Eventos getEvntos() {
		return getPrimaryKey().getEventos();
	}
	/**
	 * @param evntos the evntos to set
	 */
	public void setEvntos(Eventos eventos) {
		getPrimaryKey().setEventos(eventos);;
	}
	
	
	/**
	 * @return the confirmado
	 */
	public String getConfirmado() {
		return confirmado;
	}
	/**
	 * @param confirmado the confirmado to set
	 */
	public void setConfirmado(String confirmado) {
		this.confirmado = confirmado;
	}
	/**
	 * @return the activo
	 */
	public int getActivo() {
		return activo;
	}
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(int activo) {
		this.activo = activo;
	}
	/**
	 * @return the asignaExamen
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idAsignaExamen")
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
