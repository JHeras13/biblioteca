package com.nttdata.app.models.entity;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibroTest {

	@Test
	void testGetId() {
		Libro libro = new Libro();
		libro.setId((long) 1);
		Long esperado = (long) 1;
		Long real = libro.getId();
		Assertions.assertEquals(esperado, real);

	}

	@Test
	void testSetId() {
		Libro libro = new Libro();
		libro.setId((long) 1);
		Long esperado = (long) 1;
		Long real = libro.getId();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testGetTitulo() {
		Libro libro = new Libro();
		libro.setTitulo("Ejemplares vivos a la luz de la luna");
		String esperado = "Ejemplares vivos a la luz de la luna";
		String real = libro.getTitulo();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testSetTitulo() {
		Libro libro = new Libro();
		libro.setTitulo("Ejemplares vivos a la luz de la luna");
		String esperado = "Ejemplares vivos a la luz de la luna";
		String real = libro.getTitulo();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testGetAutor() {
		Libro libro = new Libro();
		libro.setAutor("Josefina Martos");
		String esperado = "Josefina Martos";
		String real = libro.getAutor();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testSetAutor() {
		Libro libro = new Libro();
		libro.setAutor("Josefina Martos");
		String esperado = "Josefina Martos";
		String real = libro.getAutor();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testGetAnio() {
		Libro libro = new Libro();
		libro.setAnio("2021");
		String esperado = "2021";
		String real = libro.getAnio();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testSetAnio() {
		Libro libro = new Libro();
		libro.setAnio("2021");
		String esperado = "2021";
		String real = libro.getAnio();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testGetEditorial() {
		Libro libro = new Libro();
		libro.setEditorial("Amarante");
		String esperado = "Amarante";
		String real = libro.getEditorial();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testSetEditorial() {
		Libro libro = new Libro();
		libro.setEditorial("Amarante");
		String esperado = "Amarante";
		String real = libro.getEditorial();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testGetGenero() {
		Libro libro = new Libro();
		libro.setGenero("Narrativa actual");
		String esperado = "Narrativa actual";
		String real = libro.getGenero();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testSetGenero() {
		Libro libro = new Libro();
		libro.setGenero("Narrativa actual");
		String esperado = "Narrativa actual";
		String real = libro.getGenero();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testGetFechaCreacion() {
		Libro libro = new Libro();
		Calendar c = Calendar.getInstance();
		libro.setFechaCreacion(c);
		Calendar esperado = c;
		Calendar real = libro.getFechaCreacion();
		Assertions.assertEquals(esperado, real);
	}

	@Test
	void testSetFechaCreacion() {
		Libro libro = new Libro();
		Calendar c = Calendar.getInstance();
		libro.setFechaCreacion(c);
		Calendar esperado = c;
		Calendar real = libro.getFechaCreacion();
		Assertions.assertEquals(esperado, real);
	}

}
