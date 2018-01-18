package com.sigecu.model;

public class RegistrarEventoModel {
	private int idEvento;
	private int idCurso;
	private int idInstructor;
	private String eDescripcion;
	private String eFechaInicio;
	private String eFechaFin;
	private String ePrograma;
	private String eHorario;
	private String eCapacidad;
	private String eTipo;
	private String eEstatus;
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getIdInstructor() {
		return idInstructor;
	}
	public void setIdInstructor(int idInstructor) {
		this.idInstructor = idInstructor;
	}
	public String geteDescripcion() {
		return eDescripcion;
	}
	public void seteDescripcion(String eDescripcion) {
		this.eDescripcion = eDescripcion;
	}
	public String geteFechaInicio() {
		return eFechaInicio;
	}
	public void seteFechaInicio(String eFechaInicio) {
		this.eFechaInicio = eFechaInicio;
	}
	public String geteFechaFin() {
		return eFechaFin;
	}
	public void seteFechaFin(String eFechaFin) {
		this.eFechaFin = eFechaFin;
	}
	public String getePrograma() {
		return ePrograma;
	}
	public void setePrograma(String ePrograma) {
		this.ePrograma = ePrograma;
	}
	public String geteHorario() {
		return eHorario;
	}
	public void seteHorario(String eHorario) {
		this.eHorario = eHorario;
	}
	public String geteCapacidad() {
		return eCapacidad;
	}
	public void seteCapacidad(String eCapacidad) {
		this.eCapacidad = eCapacidad;
	}
	public String geteTipo() {
		return eTipo;
	}
	public void seteTipo(String eTipo) {
		this.eTipo = eTipo;
	}
	public String geteEstatus() {
		return eEstatus;
	}
	public void seteEstatus(String eEstatus) {
		this.eEstatus = eEstatus;
	}
	
	public RegistrarEventoModel() {
		super();
	}
	public RegistrarEventoModel(int idEvento, int idCurso, int idInstructor, String eDescripcion, String eFechaInicio,
			String eFechaFin, String ePrograma, String eHorario, String eCapacidad, String eTipo, String eEstatus) {
		super();
		this.idEvento = idEvento;
		this.idCurso = idCurso;
		this.idInstructor = idInstructor;
		this.eDescripcion = eDescripcion;
		this.eFechaInicio = eFechaInicio;
		this.eFechaFin = eFechaFin;
		this.ePrograma = ePrograma;
		this.eHorario = eHorario;
		this.eCapacidad = eCapacidad;
		this.eTipo = eTipo;
		this.eEstatus = eEstatus;
	}
	
	
	
	

}
