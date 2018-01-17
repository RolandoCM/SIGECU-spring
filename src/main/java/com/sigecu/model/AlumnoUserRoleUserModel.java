package com.sigecu.model;

public class AlumnoUserRoleUserModel {

	private int id_alumno;
	private String a_nombre;
	private String a_paterno;
	private String a_materno;
	private String a_telefono;
	private String a_email;
	private String a_carrera;
	private String a_notebook;
	private String a_status;
	private String username;
	private String password;
	
	//user_Role
	private int user_role_id;
	private String descripcion;
	private String Role;
	private String usernameRole;
	
	
	//user
	
	private String usernameUser;
	private String passwordUser;
	private int enable;
	private String img;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlumnoUserRoleUserModel [id_alumno=" + id_alumno + ", a_nombre=" + a_nombre + ", a_paterno=" + a_paterno
				+ ", a_materno=" + a_materno + ", a_telefono=" + a_telefono + ", a_email=" + a_email + ", a_carrera="
				+ a_carrera + ", a_notebook=" + a_notebook + ", a_status=" + a_status + ", username=" + username
				+ ", password=" + password + ", user_role_id=" + user_role_id + ", descripcion=" + descripcion
				+ ", Role=" + Role + ", usernameRole=" + usernameRole + ", usernameUser=" + usernameUser
				+ ", passwordUser=" + passwordUser + ", enable=" + enable + "]";
	}


	public AlumnoUserRoleUserModel(int id_alumno, String a_nombre, String a_paterno, String a_materno,
			String a_telefono, String a_email, String a_carrera, String a_notebook, String a_status, String username,
			String password, int user_role_id, String descripcion, String role, String usernameRole,
			String usernameUser, String passwordUser, int enable, String img) {
		this.id_alumno = id_alumno;
		this.a_nombre = a_nombre;
		this.a_paterno = a_paterno;
		this.a_materno = a_materno;
		this.a_telefono = a_telefono;
		this.a_email = a_email;
		this.a_carrera = a_carrera;
		this.a_notebook = a_notebook;
		this.a_status = a_status;
		this.username = username;
		this.password = password;
		this.user_role_id = user_role_id;
		this.descripcion = descripcion;
		Role = role;
		this.usernameRole = usernameRole;
		this.usernameUser = usernameUser;
		this.passwordUser = passwordUser;
		this.enable = enable;
		this.img = img;
	}


	/**
	 * @return the id_alumno
	 */
	public int getId_alumno() {
		return id_alumno;
	}


	/**
	 * @param id_alumno the id_alumno to set
	 */
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}


	/**
	 * @return the a_nombre
	 */
	public String getA_nombre() {
		return a_nombre;
	}


	/**
	 * @param a_nombre the a_nombre to set
	 */
	public void setA_nombre(String a_nombre) {
		this.a_nombre = a_nombre;
	}


	/**
	 * @return the a_paterno
	 */
	public String getA_paterno() {
		return a_paterno;
	}


	/**
	 * @param a_paterno the a_paterno to set
	 */
	public void setA_paterno(String a_paterno) {
		this.a_paterno = a_paterno;
	}


	/**
	 * @return the a_materno
	 */
	public String getA_materno() {
		return a_materno;
	}


	/**
	 * @param a_materno the a_materno to set
	 */
	public void setA_materno(String a_materno) {
		this.a_materno = a_materno;
	}


	/**
	 * @return the a_telefono
	 */
	public String getA_telefono() {
		return a_telefono;
	}


	/**
	 * @param a_telefono the a_telefono to set
	 */
	public void setA_telefono(String a_telefono) {
		this.a_telefono = a_telefono;
	}


	/**
	 * @return the a_email
	 */
	public String getA_email() {
		return a_email;
	}


	/**
	 * @param a_email the a_email to set
	 */
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}


	/**
	 * @return the a_carrera
	 */
	public String getA_carrera() {
		return a_carrera;
	}


	/**
	 * @param a_carrera the a_carrera to set
	 */
	public void setA_carrera(String a_carrera) {
		this.a_carrera = a_carrera;
	}


	/**
	 * @return the a_notebook
	 */
	public String getA_notebook() {
		return a_notebook;
	}


	/**
	 * @param a_notebook the a_notebook to set
	 */
	public void setA_notebook(String a_notebook) {
		this.a_notebook = a_notebook;
	}


	/**
	 * @return the a_status
	 */
	public String getA_status() {
		return a_status;
	}


	/**
	 * @param a_status the a_status to set
	 */
	public void setA_status(String a_status) {
		this.a_status = a_status;
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
	 * @return the user_role_id
	 */
	public int getUser_role_id() {
		return user_role_id;
	}


	/**
	 * @param user_role_id the user_role_id to set
	 */
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
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


	/**
	 * @return the role
	 */
	public String getRole() {
		return Role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		Role = role;
	}


	/**
	 * @return the usernameRole
	 */
	public String getUsernameRole() {
		return usernameRole;
	}


	/**
	 * @param usernameRole the usernameRole to set
	 */
	public void setUsernameRole(String usernameRole) {
		this.usernameRole = usernameRole;
	}


	/**
	 * @return the usernameUser
	 */
	public String getUsernameUser() {
		return usernameUser;
	}


	/**
	 * @param usernameUser the usernameUser to set
	 */
	public void setUsernameUser(String usernameUser) {
		this.usernameUser = usernameUser;
	}


	/**
	 * @return the passwordUser
	 */
	public String getPasswordUser() {
		return passwordUser;
	}


	/**
	 * @param passwordUser the passwordUser to set
	 */
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}


	/**
	 * @return the enable
	 */
	public int getEnable() {
		return enable;
	}


	/**
	 * @param enable the enable to set
	 */
	public void setEnable(int enable) {
		this.enable = enable;
	}


	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}


	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}


	
	
	
}
