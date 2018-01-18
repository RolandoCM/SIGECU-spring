package com.sigecu.model;

public class AltaAlumnoModel {
	private String idAlumno;
	private String idEvento;
	private String confirmado;
	private String activo;
	private String asignaExamen;
	/**
	 * 
	 */
	public AltaAlumnoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idAlumno
	 * @param idEvento
	 * @param confirmado
	 * @param activo
	 * @param asignaExamen
	 */
	public AltaAlumnoModel(String idAlumno, String idEvento, String confirmado, String activo, String asignaExamen) {
		super();
		this.idAlumno = idAlumno;
		this.idEvento = idEvento;
		this.confirmado = confirmado;
		this.activo = activo;
		this.asignaExamen = asignaExamen;
	}
	/**
	 * @return the idAlumno
	 */
	public String getIdAlumno() {
		return idAlumno;
	}
	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	/**
	 * @return the idEvento
	 */
	public String getIdEvento() {
		return idEvento;
	}
	/**
	 * @param idEvento the idEvento to set
	 */
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
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
	public String getActivo() {
		return activo;
	}
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(String activo) {
		this.activo = activo;
	}
	/**
	 * @return the asignaExamen
	 */
	public String getAsignaExamen() {
		return asignaExamen;
	}
	/**
	 * @param asignaExamen the asignaExamen to set
	 */
	public void setAsignaExamen(String asignaExamen) {
		this.asignaExamen = asignaExamen;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AltaAlumnoModel [idAlumno=" + idAlumno + ", idEvento=" + idEvento + ", confirmado=" + confirmado
				+ ", activo=" + activo + ", asignaExamen=" + asignaExamen + "]";
	}
	
	
}
