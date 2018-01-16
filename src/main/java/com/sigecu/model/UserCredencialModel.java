/**
 * 
 */
package com.sigecu.model;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 08/01/2018
 *
 */
public class UserCredencialModel {
	private String username;
	private String password;
	
	/**
	 * @param username
	 * @param password
	 */
	public UserCredencialModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserCredencialModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
