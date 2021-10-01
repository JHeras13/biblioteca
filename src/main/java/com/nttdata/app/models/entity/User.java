package com.nttdata.app.models.entity;

/**
 * Declaración de clase pojo de modelo de objeto usuario
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */
public class User {

	/**
	 * Declaración de atributos de la clase.
	 */

	private Integer id;

	private String email;

	private String first_name;

	private String last_name;

	private String avatar;

	/**
	 * Declaración de metodos Getters y Setters.
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
