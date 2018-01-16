/**
 * 
 */
package com.sigecu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 05/01/2018
 *
 */
@Entity
@Table(name="instructor")
public class Instructor {
	private int idInstructor;
	private String iNombre;
	private String iPaterno;
	private String iMaterno;
	private String carrera;
	private String iEmail;
	private String iTelefono;
	private String iDireccion;
	private Users user;
	
	/**
	 * 
	 */
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param idIntructor
	 * @param iNombre
	 * @param iPaterno
	 * @param iMaterno
	 * @param carrera
	 * @param iEmail
	 * @param iTelefono
	 * @param iDireccion
	 * @param user
	 */
	public Instructor( String iNombre, String iPaterno, String iMaterno, String carrera, String iEmail,
			String iTelefono, String iDireccion, Users user) {
		super();
		this.iNombre = iNombre;
		this.iPaterno = iPaterno;
		this.iMaterno = iMaterno;
		this.carrera = carrera;
		this.iEmail = iEmail;
		this.iTelefono = iTelefono;
		this.iDireccion = iDireccion;
		this.user = user;
	}

	/**
	 * @return the idIntructor
	 */
	@Id
	@GeneratedValue
	@Column(name="id_instructor")
	public int getIdInstructor() {
		return idInstructor;
	}
	/**
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * @param idIntructor the idIntructor to set
	 */
	public void setIdInstructor(int idInstructor) {
		this.idInstructor = idInstructor;
	}
	/**
	 * @return the iNombre
	 */
	public String getiNombre() {
		return iNombre;
	}
	/**
	 * @param iNombre the iNombre to set
	 */
	public void setiNombre(String iNombre) {
		this.iNombre = iNombre;
	}
	/**
	 * @return the iPaterno
	 */
	public String getiPaterno() {
		return iPaterno;
	}
	/**
	 * @param iPaterno the iPaterno to set
	 */
	public void setiPaterno(String iPaterno) {
		this.iPaterno = iPaterno;
	}
	/**
	 * @return the iMaterno
	 */
	public String getiMaterno() {
		return iMaterno;
	}
	/**
	 * @param iMaterno the iMaterno to set
	 */
	public void setiMaterno(String iMaterno) {
		this.iMaterno = iMaterno;
	}
	/**
	 * @return the iEmail
	 */
	public String getiEmail() {
		return iEmail;
	}
	/**
	 * @param iEmail the iEmail to set
	 */
	public void setiEmail(String iEmail) {
		this.iEmail = iEmail;
	}
	/**
	 * @return the iTelefono
	 */
	public String getiTelefono() {
		return iTelefono;
	}
	/**
	 * @param iTelefono the iTelefono to set
	 */
	public void setiTelefono(String iTelefono) {
		this.iTelefono = iTelefono;
	}
	/**
	 * @return the iDireccion
	 */
	public String getiDireccion() {
		return iDireccion;
	}
	/**
	 * @param iDireccion the iDireccion to set
	 */
	public void setiDireccion(String iDireccion) {
		this.iDireccion = iDireccion;
	}
	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
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
