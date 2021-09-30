package com.nttdata.app.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.app.models.entity.Libro;

/**
 * Declaración de interfaz de acceso a datos a la entidad libro.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

public interface ILibroDao extends JpaRepository<Libro, Long> {

	/**
	 * Método que permite buscar libro por ID.
	 * 
	 * @return Retorna un objeto de tipo libro.
	 */
	public Optional<Libro> findById(Long idLibro);

	/**
	 * Método que obtiene un listado de todos los libros.
	 * 
	 * @return Retorna un arreglo de objetos de tipo libro.
	 */
	public List<Libro> findAll();

	/**
	 * Método que permite guardar un nuevo libro o editar uno existente.
	 * 
	 * @return Retorna un objeto de tipo libro.
	 */
	public Libro save(Libro libro);

	/**
	 * Método que permite eliminar un libro existente.
	 */
	public void deleteById(Long idLibro);
}
