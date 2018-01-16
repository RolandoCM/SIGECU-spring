package com.sigecu.model;
/**
 * @author Anel
 *
 */


public class RespuestaALMModel {
	private int idRespuestaALM;
	private RespuestasModel respuestasModel;
	private AsignaExamenModel asignaExamen;
	private String seleccionada;
	/**
	 * 
	 */
	public RespuestaALMModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idRespuestaALM
	 * @param respuestasModel
	 * @param asignaExamen
	 * @param seleccionada
	 */
	public RespuestaALMModel(int idRespuestaALM, RespuestasModel respuestasModel, AsignaExamenModel asignaExamen,
			String seleccionada) {
		super();
		this.idRespuestaALM = idRespuestaALM;
		this.respuestasModel = respuestasModel;
		this.asignaExamen = asignaExamen;
		this.seleccionada = seleccionada;
	}
	/**
	 * @return the idRespuestaALM
	 */
	public int getIdRespuestaALM() {
		return idRespuestaALM;
	}
	/**
	 * @param idRespuestaALM the idRespuestaALM to set
	 */
	public void setIdRespuestaALM(int idRespuestaALM) {
		this.idRespuestaALM = idRespuestaALM;
	}
	/**
	 * @return the respuestasModel
	 */
	public RespuestasModel getRespuestasModel() {
		return respuestasModel;
	}
	/**
	 * @param respuestasModel the respuestasModel to set
	 */
	public void setRespuestasModel(RespuestasModel respuestasModel) {
		this.respuestasModel = respuestasModel;
	}
	/**
	 * @return the asignaExamen
	 */
	public AsignaExamenModel getAsignaExamen() {
		return asignaExamen;
	}
	/**
	 * @param asignaExamen the asignaExamen to set
	 */
	public void setAsignaExamen(AsignaExamenModel asignaExamen) {
		this.asignaExamen = asignaExamen;
	}
	/**
	 * @return the seleccionada
	 */
	public String getSeleccionada() {
		return seleccionada;
	}
	/**
	 * @param seleccionada the seleccionada to set
	 */
	public void setSeleccionada(String seleccionada) {
		this.seleccionada = seleccionada;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RespuestaALMModel [idRespuestaALM=" + idRespuestaALM + ", respuestasModel=" + respuestasModel
				+ ", asignaExamen=" + asignaExamen + ", seleccionada=" + seleccionada + "]";
	}
	
	
	
}
