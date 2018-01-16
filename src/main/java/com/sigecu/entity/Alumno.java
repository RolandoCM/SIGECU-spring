package com.sigecu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 02/01/2018
 *
 */
@Entity
@Table(name="alumno")
public class Alumno {
	
	private int idAlumno;
	private String aNombre;
	private String aPaterno;
	private String aMaterno;
	private String aTelefono;
	private String aEmail;
	private String aCarrera;
	private String aNotebook;
	private String aStatus;	
	private Users user;
	
	private Set<Alumno_Has_Eventos> alumnoHasEventos = new HashSet<>(); 
	public Alumno() {
	}
	/**
	 * @param a_nombre
	 * @param a_paterno
	 * @param a_materno
	 * @param a_telefono
	 * @param a_email
	 * @param a_carrera
	 * @param a_notebook
	 * @param a_status
	 */
	public Alumno( String a_nombre, String a_paterno, String a_materno, String a_telefono, String a_email,
			String a_carrera, String a_notebook, String a_status) {
		this.aNombre = a_nombre;
		this.aPaterno = a_paterno;
		this.aMaterno = a_materno;
		this.aTelefono = a_telefono;
		this.aEmail = a_email;
		this.aCarrera = a_carrera;
		this.aNotebook = a_notebook;
		this.aStatus = a_status;
	}
	public void addEventos(Alumno_Has_Eventos alm_has_event) {
		this.alumnoHasEventos.add(alm_has_event);
		
	}
	/**
	 * @return the id_alumno
	 */
	@Id
	@GeneratedValue
	@Column(name="id_alumno")
	public int getIdAlumno() {
		return idAlumno;
	}
	/**
	 * @param id_alumno the id_alumno to set
	 */
	public void setIdAlumno(int id_alumno) {
		this.idAlumno = id_alumno;
	}
	/**
	 * @return the aNombre
	 */
	public String getaNombre() {
		return aNombre;
	}
	/**
	 * @param aNombre the aNombre to set
	 */
	public void setaNombre(String aNombre) {
		this.aNombre = aNombre;
	}
	/**
	 * @return the aPaterno
	 */
	public String getaPaterno() {
		return aPaterno;
	}
	/**
	 * @param aPaterno the aPaterno to set
	 */
	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}
	/**
	 * @return the aMaterno
	 */
	public String getaMaterno() {
		return aMaterno;
	}
	/**
	 * @param aMaterno the aMaterno to set
	 */
	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}
	/**
	 * @return the aTelefono
	 */
	public String getaTelefono() {
		return aTelefono;
	}
	/**
	 * @param aTelefono the aTelefono to set
	 */
	public void setaTelefono(String aTelefono) {
		this.aTelefono = aTelefono;
	}
	/**
	 * @return the aEmail
	 */
	public String getaEmail() {
		return aEmail;
	}
	/**
	 * @param aEmail the aEmail to set
	 */
	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}
	/**
	 * @return the aCarrera
	 */
	public String getaCarrera() {
		return aCarrera;
	}
	/**
	 * @param aCarrera the aCarrera to set
	 */
	public void setaCarrera(String aCarrera) {
		this.aCarrera = aCarrera;
	}
	/**
	 * @return the aNotebook
	 */
	public String getaNotebook() {
		return aNotebook;
	}
	/**
	 * @param aNotebook the aNotebook to set
	 */
	public void setaNotebook(String aNotebook) {
		this.aNotebook = aNotebook;
	}
	/**
	 * @return the aStatus
	 */
	public String getaStatus() {
		return aStatus;
	}
	/**
	 * @param aStatus the aStatus to set
	 */
	public void setaStatus(String aStatus) {
		this.aStatus = aStatus;
	}
	@OneToMany(mappedBy = "primaryKey.alumno", cascade = CascadeType.ALL)
	public Set<Alumno_Has_Eventos> getAlumnoHasEventos() {
		return alumnoHasEventos;
	}
	/**
	 * @param alumno_has_eventos the alumno_has_eventos to set
	 */
	public void setAlumnoHasEventos(Set<Alumno_Has_Eventos> alumno_has_eventos) {
		this.alumnoHasEventos = alumno_has_eventos;
	}
	/**
	 * @return the user
	 */
	@ManyToOne
	@JoinColumn(name = "user_id_user")
	public Users getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
}
