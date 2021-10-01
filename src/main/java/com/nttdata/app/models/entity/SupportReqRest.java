package com.nttdata.app.models.entity;

/**
 * Declaración de clase de pojo de modelo de SupportReqRest.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */
public class SupportReqRest {

	/**
	 * Declaración de atributos de la clase.
	 */

	private String url;

	private String text;

	/**
	 * Declaración de metodos Getters y Setters.
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
