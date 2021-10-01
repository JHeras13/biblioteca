package com.nttdata.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Declaración de clase de pojo de modelo de DataUser.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

public class DataUser {

	/**
	 * Declaración de atributos de la clase.
	 */
	private User data;

	@JsonIgnore
	private SupportReqRest support;

	/**
	 * Declaración de metodos Getters y Setters.
	 */
	public User getData() {
		return data;
	}

}
