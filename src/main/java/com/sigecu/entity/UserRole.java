/**
 * 
 */
package com.sigecu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 08/01/2018
 *
 */
@Entity
@Table(name="user_roles", uniqueConstraints = @UniqueConstraint(
		columnNames = {"role", "username"}))
public class UserRole {
	@Id
	@GeneratedValue
	@Column(name="user_role_id", unique = true, nullable=false)
	private Integer userRoleId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="username", nullable = false)
	private Users user;
	@Column(name="role", nullable=false, length = 45)
	private String role;
	private String descripcion;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userRoleId
	 * @param user
	 * @param role
	 */
	public UserRole(Integer userRoleId, Users user, String role, String descripcion) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
		this.descripcion = descripcion;
	}

	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
