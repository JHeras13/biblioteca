package com.nttdata.app.models.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.persistence.PrePersist;

/**
 * Declaración de clase de entidad a tabla de nombre libro.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

@Entity
@Table(name = "libro")
public class Libro implements Serializable {

	/**
	 * Declaración de atributos de la clase, para el mapeo de la tabla.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo", nullable = false)
	@NotEmpty
	private String titulo;

	@Column(name = "autor", nullable = false)
	@NotEmpty
	private String autor;

	@Column(name = "anio", nullable = false)
	@NotEmpty
	private String anio;

	@Column(name = "editorial", nullable = false)
	@NotEmpty
	private String editorial;

	@Column(name = "genero", nullable = false)
	@NotEmpty
	private String genero;

	@Column(name = "fecha_creacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaCreacion;

	@PrePersist
	public void PrePersist() {
		fechaCreacion = Calendar.getInstance();
	}

	/**
	 * Declaración de metodos Getters y Setters.
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	private static final long serialVersionUID = 1L;

}
