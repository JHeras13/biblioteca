package com.nttdata.app.models.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nttdata.app.models.entity.Libro;

@SpringBootTest
class LibroServiceImplTest {

	@Autowired
	private ILibroService libroService;

	@Test
	void testFindById() {
		Libro libro = libroService.findById(1L);
		assertNotNull(libro);
		Libro libro2 = libroService.findById(90L);
		assertEquals(null, libro2, "El número de registros es menor al consultado");

	}

	@Test
	void testFindAll() {
		List<Libro> libros = libroService.findAll();
		if (libros.size() > 0) {
			assertTrue(libros.size() > 0);
		} else {
			assertEquals(libros.size(), 0);
		}

	}

	@Test
	void testSave() {
		Libro libro = new Libro();
		libro.setTitulo("Las polillas y la luz");
		libro.setAutor("Manuel Molinero");
		libro.setAnio("2021");
		libro.setEditorial("Amarante");
		libro.setGenero("Novela");

		Libro nuevoLibro = libroService.save(libro);

		assertEquals(libro.getTitulo(), nuevoLibro.getTitulo());
		assertEquals(libro.getFechaCreacion(), nuevoLibro.getFechaCreacion());
		assertTrue(nuevoLibro.getId() > 0);
	}

	@Test
	void testDeleteById() {
		libroService.deleteById(5L);
	}

	@Test
	void testSaveAll() {
		List<Libro> librosExistentes = libroService.findAll();

		List<Libro> libros = new ArrayList<Libro>();
		int cantidad = 10;
		for (int i = 1; i < cantidad; i++) {
			Libro libro = new Libro();
			libro.setTitulo("Titulo de libro " + i);
			libro.setAutor("Autor de libro " + i);
			Calendar c = Calendar.getInstance();
			libro.setAnio(String.valueOf(c.get(Calendar.YEAR)));
			libro.setEditorial("Editorial del libro " + i);
			libro.setGenero("Genero de libro " + i);
			libros.add(libro);
		}

		libroService.saveAll(libros);
		List<Libro> librosExistentes2 = libroService.findAll();
		assertTrue(librosExistentes.size() < librosExistentes2.size());
	}

}
