package com.nttdata.app.models.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Declaración de clase modelo del objeto de pagina de usuario
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

public class UserPage {

	/**
	 * Declaración de atributos de la clase.
	 */

	private Integer page;

	private Integer per_page;

	private Integer total;

	private Integer total_pages;

	private List<User> data;

	@JsonIgnore
	private SupportReqRest support;

	/**
	 * Declaración de metodos Getters y Setters.
	 */

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

}
