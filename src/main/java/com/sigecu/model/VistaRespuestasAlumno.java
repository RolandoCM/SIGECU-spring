/**
 * 
 */
package com.sigecu.model;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 14/01/2018
 *
 */
public class VistaRespuestasAlumno {
	private int idRespuesta;
	private int idAsignaExamen;
	private int seleccionada;
	/**
	 * 
	 */
	public VistaRespuestasAlumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idRespuesta
	 * @param idAsignaExamen
	 * @param seleccionada
	 */
	public VistaRespuestasAlumno(int idRespuesta, int idAsignaExamen, int seleccionada) {
		super();
		this.idRespuesta = idRespuesta;
		this.idAsignaExamen = idAsignaExamen;
		this.seleccionada = seleccionada;
	}
	/**
	 * @return the idRespuesta
	 */
	public int getIdRespuesta() {
		return idRespuesta;
	}
	/**
	 * @param idRespuesta the idRespuesta to set
	 */
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	/**
	 * @return the idAsignaExamen
	 */
	public int getIdAsignaExamen() {
		return idAsignaExamen;
	}
	/**
	 * @param idAsignaExamen the idAsignaExamen to set
	 */
	public void setIdAsignaExamen(int idAsignaExamen) {
		this.idAsignaExamen = idAsignaExamen;
	}
	/**
	 * @return the seleccionada
	 */
	public int getSeleccionada() {
		return seleccionada;
	}
	/**
	 * @param seleccionada the seleccionada to set
	 */
	public void setSeleccionada(int seleccionada) {
		this.seleccionada = seleccionada;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VistaRespuestasAlumno [idRespuesta=" + idRespuesta + ", idAsignaExamen=" + idAsignaExamen
				+ ", seleccionada=" + seleccionada + "]";
	}
	
	

}
