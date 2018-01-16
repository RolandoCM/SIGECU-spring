/**
 * 
 */
package com.sigecu.exception;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 13/01/2018
 *
 */
public class BusinessException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idException;
	private String msj;
	/**
	 * @return the idException
	 */
	public int getIdException() {
		return idException;
	}
	/**
	 * @param idException the idException to set
	 */
	public void setIdException(int idException) {
		this.idException = idException;
	}
	/**
	 * @return the msj
	 */
	public String getMsj() {
		return msj;
	}
	/**
	 * @param msj the msj to set
	 */
	public void setMsj(String msj) {
		this.msj = msj;
	}
	

}
