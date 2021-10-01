package com.nttdata.app.models.service;

import java.util.List;

import com.nttdata.app.models.entity.Libro;

/**
 * Declaración de metodos de comportamiento de Libro.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

public interface ILibroService {

	/**
	 * Método que permite buscar libro por ID.
	 * @param id del libro que se desea buscar
	 * @return Retorna un objeto de tipo libro.
	 */
	public Libro findById(Long idLibro);

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

	
	/**
	 * Método que permite guardar un listado de libros
	 * @param libros agrupación de objetos que se desea guardar
	 * @return listados de libros guardados
	 */
	public Iterable<Libro> saveAll(List<Libro> libros);
}
