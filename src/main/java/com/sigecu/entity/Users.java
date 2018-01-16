/**
 * 
 */
package com.sigecu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 08/01/2018
 *
 */
@Entity
@Table(name="users")
public class Users {
	@Id
	@Column(name="username", unique=true, nullable= false, length=45)
	private String username;
	@Column(name="password", nullable=false, length=60)
	private String password;
	@Column(name="enable", nullable=false)
	private boolean enabled;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user")
	private Set<UserRole> userRole = new HashSet<UserRole>();
	private String imagen;

	/**
	 * 
	 */
	public Users() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 */
	public Users(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param userRole
	 */
	public Users(String username, String password, boolean enabled, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
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
	/**
	 * @return the userRole
	 */
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	

}
