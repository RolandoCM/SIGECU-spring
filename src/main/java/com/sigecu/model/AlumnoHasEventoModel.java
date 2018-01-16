package com.sigecu.model;

public class AlumnoHasEventoModel {
	
	private int a_idalumno;
	private int e_idevento;
	private String confirmado;
	private String activo;
	private int aE_idasignaExamen;
	public int getA_idalumno() {
		return a_idalumno;
	}
	public void setA_idalumno(int a_idalumno) {
		this.a_idalumno = a_idalumno;
	}
	public int getE_idevento() {
		return e_idevento;
	}
	public void setE_idevento(int e_idevento) {
		this.e_idevento = e_idevento;
	}
	public String getConfirmado() {
		return confirmado;
	}
	public void setConfirmado(String confirmado) {
		this.confirmado = confirmado;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public int getaE_idasignaExamen() {
		return aE_idasignaExamen;
	}
	public void setaE_idasignaExamen(int aE_idasignaExamen) {
		this.aE_idasignaExamen = aE_idasignaExamen;
	}
	
	@Override
	public String toString() {
		return "alumnoEvento [a_idalumno=" + a_idalumno + ", e_idevento=" + e_idevento + ", confirmado=" + confirmado + ", activo=" + activo + ", aE_idasignaExamen="+ aE_idasignaExamen +"]";
	}

}
