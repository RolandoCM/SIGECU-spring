package com.sigecu.model;
/**
 * @author Anel
 *
 */
public class AsignaExamenModel {
	private int idasignaExamen;
	private String asignado;
	private String fechaInicio;
	private String fechaFin;
	private String horaInicio;
	private String horafin;
	private String realizado;
	private String status;
	
	/**
	 * 
	 */
	public AsignaExamenModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idasignaExamen
	 * @param asignado
	 * @param fechaInicio
	 * @param fechaFin
	 * @param horaInicio
	 * @param horafin
	 * @param realizado
	 * @param status
	 */
	public AsignaExamenModel(int idasignaExamen, String asignado, String fechaInicio, String fechaFin,
			String horaInicio, String horafin, String realizado, String status) {
		super();
		this.idasignaExamen = idasignaExamen;
		this.asignado = asignado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaInicio = horaInicio;
		this.horafin = horafin;
		this.realizado = realizado;
		this.status = status;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AsignaExamenModel [idasignaExamen=" + idasignaExamen + ", asignado=" + asignado + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", horaInicio=" + horaInicio + ", horafin=" + horafin
				+ ", realizado=" + realizado + ", status=" + status + "]";
	}
	
}
