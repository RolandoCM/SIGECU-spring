package com.sigecu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificado")
public class Certificado {

	@Id
	@GeneratedValue
	@Column(name = "idCertificado")
	private int idCertificado;
	@Column(name = "curso")
	private String curso;
	@Column(name = "alumno")
	private String alumno;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "calificacion")
	private float califiacion;

	public Certificado(int idCertificado, String curso, String alumno, String fecha, float califiacion) {
		super();
		this.idCertificado = idCertificado;
		this.curso = curso;
		this.alumno = alumno;
		this.fecha = fecha;
		this.califiacion = califiacion;
	}

	public Certificado() {
	}

	// Getters & Setters
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

	public float getCalifiacion() {
		return califiacion;
	}

	public void setCalifiacion(float califiacion) {
		this.califiacion = califiacion;
	}
}
