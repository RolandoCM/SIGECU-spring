/**
 * 
 */
package com.sigecu.model;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 17/12/2017
 *
 */
public class CursoModel {

	/**
	 * 
	 */
	private int idCurso;
	private String cNombre;
	private String cDescripcion;
	
	public CursoModel() {
	}
	public CursoModel(int idCurso, String cNombre, String cDescripcion){
		this.idCurso=idCurso;
		this.cNombre=cNombre;
		this.cDescripcion=cDescripcion;
	}
	/**
	 * @return the idCurso
	 */
	public int getIdCurso() {
		return idCurso;
	}

	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	/**
	 * @return the cNombre
	 */
	public String getcNombre() {
		return cNombre;
	}

	/**
	 * @param cNombre the cNombre to set
	 */
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}

	/**
	 * @return the cDescripcion
	 */
	public String getcDescripcion() {
		return cDescripcion;
	}

	/**
	 * @param cDescripcion the cDescripcion to set
	 */
	public void setcDescripcion(String cDescripcion) {
		this.cDescripcion = cDescripcion;
	}
	
	public String toString() {
		return "idCurso="+idCurso+" cNombre: "+cNombre+" cDescripcion: "+cDescripcion;
	}
	

}
