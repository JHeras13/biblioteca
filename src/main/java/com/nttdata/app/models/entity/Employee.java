package com.nttdata.app.models.entity;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Declaración de clase de pojo de modelo de Employee.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Employee {

	/**
	 * Declaración de atributos de la clase.
	 */
	private String id;

	private String name;

	private String job;

	private Calendar createdAt;

	private Calendar updatedAt;

	/**
	 * Declaración de metodos Getters y Setters.
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}

}
