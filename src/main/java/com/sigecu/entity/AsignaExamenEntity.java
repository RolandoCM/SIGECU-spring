package com.sigecu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "asignaExamen")

public class AsignaExamenEntity {
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="idasignaExamen",unique=true,nullable=false)
	private int idasignaExamen;
	@Column (name="asignado")
	private String asignado;
	@Column (name="fechaInicio")
	private String fechaInicio;
	@Column (name="fechaFin")
	private String fechaFin;
	@Column (name="horaInicio")
	private String horaInicio;
	@Column (name="horafin")
	private String horafin;
	@Column (name="realizado")
	private String realizado;
	@Column (name="status")
	private String status;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="asignaExamen")
	private Set<RespuestaALMEntity> respuestasAML = new HashSet<>();
	@OneToMany(fetch=FetchType.EAGER, mappedBy="asignaExamen")
	private Set<Alumno_Has_Eventos> alumnoHasEventos = new HashSet<>();
	
	
	public int getIdasignaExamen() {
		return idasignaExamen;
	}
	public void setIdasignaExamen(int idasignaExamen) {
		this.idasignaExamen = idasignaExamen;
	}
	public String getAsignado() {
		return asignado;
	}
	public void setAsignado(String asignado) {
		this.asignado = asignado;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHorafin() {
		return horafin;
	}
	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}
	public String getRealizado() {
		return realizado;
	}
	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the respuestasAML
	 */
	public Set<RespuestaALMEntity> getRespuestasAML() {
		return respuestasAML;
	}
	/**
	 * @param respuestasAML the respuestasAML to set
	 */
	public void setRespuestasAML(Set<RespuestaALMEntity> respuestasAML) {
		this.respuestasAML = respuestasAML;
	}
	/**
	 * @return the alumnoHasEventos
	 */
	public Set<Alumno_Has_Eventos> getAlumnoHasEventos() {
		return alumnoHasEventos;
	}
	/**
	 * @param alumnoHasEventos the alumnoHasEventos to set
	 */
	public void setAlumnoHasEventos(Set<Alumno_Has_Eventos> alumnoHasEventos) {
		this.alumnoHasEventos = alumnoHasEventos;
	}
	public AsignaExamenEntity() {
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AsignaExamenEntity [idasignaExamen=" + idasignaExamen + ", asignado=" + asignado + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", horaInicio=" + horaInicio + ", horafin=" + horafin
				+ ", realizado=" + realizado + ", status=" + status + ", respuestasAML=" + respuestasAML
				+ ", alumnoHasEventos=" + alumnoHasEventos + "]";
	}
	

}





