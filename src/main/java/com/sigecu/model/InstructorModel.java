/**
 * 
 */
package com.sigecu.model;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 05/01/2018
 *
 */
public class InstructorModel {
	
	private int id;
	private String carrera;
	private String iDireccion;
	private String iEmail;
	private String iMaterno;
	private String iNombre;
	private String iPaterno;
	private String iTelefono;
	/**
	 * 
	 */
	public InstructorModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param carrera
	 * @param iDireccion
	 * @param iEmail
	 * @param iMaterno
	 * @param iNombre
	 * @param iPaterno
	 * @param iTelefono
	 */
	public InstructorModel(int id, String carrera, String iDireccion, String iEmail, String iMaterno, String iNombre,
			String iPaterno, String iTelefono) {
		super();
		this.id = id;
		this.carrera = carrera;
		this.iDireccion = iDireccion;
		this.iEmail = iEmail;
		this.iMaterno = iMaterno;
		this.iNombre = iNombre;
		this.iPaterno = iPaterno;
		this.iTelefono = iTelefono;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}
	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
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
	
	
	
}
