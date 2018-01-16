/**
 * 
 */
package com.sigecu.model;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 14/12/2017
 *
 */
public class EvaluacionesModel {

	/**
	 * 
	 */
	private int idevaluacion;
	private String eNombre;
	private CursoModel curso;
	private String eTiempo;
	private String ePorcentaje;

	public EvaluacionesModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the curso
	 */
	public CursoModel getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(CursoModel curso) {
		this.curso = curso;
	}

	/**
	 * @return the idevaluacion
	 */
	public int getIdevaluacion() {
		return idevaluacion;
	}

	/**
	 * @param idevaluacion
	 *            the idevaluacion to set
	 */
	public void setIdevaluacion(int idevaluacion) {
		this.idevaluacion = idevaluacion;
	}

	/**
	 * @return the eNombre
	 */
	public String geteNombre() {
		return eNombre;
	}

	/**
	 * @param eNombre
	 *            the eNombre to set
	 */
	public void seteNombre(String eNombre) {
		this.eNombre = eNombre;
	}

	/**
	 * @return the eTiempo
	 */
	public String geteTiempo() {
		return eTiempo;
	}

	/**
	 * @param eTiempo
	 *            the eTiempo to set
	 */
	public void seteTiempo(String eTiempo) {
		this.eTiempo = eTiempo;
	}

	/**
	 * @return the ePorcentaje
	 */
	public String getePorcentaje() {
		return ePorcentaje;
	}

	/**
	 * @param ePorcentaje
	 *            the ePorcentaje to set
	 */
	public void setePorcentaje(String ePorcentaje) {
		this.ePorcentaje = ePorcentaje;
	}

	public String toString() {
		return " idEvaluacion: " + idevaluacion + " eNombre: " + eNombre + " eTiempo: " + eTiempo + " ePorcentaje: "
				+ ePorcentaje;
	}

}
