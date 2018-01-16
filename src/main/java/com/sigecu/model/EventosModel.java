package com.sigecu.model;

import com.sigecu.entity.Cursos;
import com.sigecu.entity.Instructor;

/**
 * @author Anel
 *
 */
public class EventosModel {
	private int idevento;
	private Cursos curso;
	private Instructor instructor;
	private String eDescripcion;
	private String eFechaInicio;
	private String eFechaTermino;
	private String ePrograma;
	private String eHorario;
	private int lugar_idlugar;
	private int t_idtempletes;
	private String eCapacidad;
	private String eTipo;
	private String eEstatus;
	public int getIdevento() {
		return idevento;
	}
	public void setIdevento(int idevento) {
		this.idevento = idevento;
	}
	/**
	 * @return the curso
	 */
	public Cursos getCurso() {
		return curso;
	}
	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
	/**
	 * @return the instructor
	 */
	public Instructor getInstructor() {
		return instructor;
	}
	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
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
	public String geteFechaTermino() {
		return eFechaTermino;
	}
	public void seteFechaTermino(String eFechaTermino) {
		this.eFechaTermino = eFechaTermino;
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
	public int getLugar_idlugar() {
		return lugar_idlugar;
	}
	public void setLugar_idlugar(int lugar_idlugar) {
		this.lugar_idlugar = lugar_idlugar;
	}
	public int getT_idtempletes() {
		return t_idtempletes;
	}
	public void setT_idtempletes(int t_idtempletes) {
		this.t_idtempletes = t_idtempletes;
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
	
	@Override
	public String toString() {
		return "EventosModel [idevento=" + idevento +" eDescripcion="
				+ eDescripcion + ", eFechaInicio =" + eFechaInicio + ", eFechaTermino ="+ eFechaTermino +", ePrograma ="+ ePrograma +", "
				+ "eHorario ="+ eHorario +", lugar_idlugar ="+ lugar_idlugar +", t_idtempletes ="+ t_idtempletes +", eCapacidad ="+ eCapacidad +", "
				+ "eTipo ="+ eTipo +", eEstatus ="+ eEstatus +"]";
	}
	
}