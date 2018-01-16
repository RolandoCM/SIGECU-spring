package com.sigecu.model;

public class CertificadoModel {
	
	private int idCertificado;
	private String curso;
	private String alumno; 
	private String fecha;
	private float calificacion;
	
	public CertificadoModel(int idCertificado, String curso, String alumno, String fecha, float calificacion) {
		super();
		this.idCertificado = idCertificado;
		this.curso = curso;
		this.alumno = alumno;
		this.fecha = fecha;
		this.calificacion = calificacion;
	}
	
	public CertificadoModel() {}
	
	@Override
	public String toString() {
		return "CertificadoModel [idCertificado="+idCertificado+",curso="+curso+",alumno="+alumno+",fecha="+fecha+",calificacion="+calificacion+"]";
	}
	
	//Getters & Setters
	public int getIdCertificado() {
		return idCertificado;
	}
	public void setIdCertificado(int idCertificado) {
		this.idCertificado = idCertificado;
	}
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	
	
	
}
