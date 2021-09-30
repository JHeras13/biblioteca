package com.nttdata.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.app.models.dao.ILibroDao;
import com.nttdata.app.models.entity.Libro;

/**
 * Declaración de clase de servicio, que implementa metodos del proveedor de
 * servicio.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroDao libroDao;

	/**
	 * Método de capa de servicio que permite buscar libro por ID.
	 * 
	 * @return Retorna un objeto de tipo libro.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<Libro> findById(Long idLibro) {
		return libroDao.findById(idLibro);
	}

	/**
	 * Método de capa de servicio que obtiene un listado de todos los libros.
	 * 
	 * @return Retorna un arreglo de objetos de tipo libro.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Libro> findAll() {
		return libroDao.findAll();
	}

	/**
	 * Método de capa de servicio que permite guardar un nuevo libro o editar uno
	 * existente.
	 * 
	 * @return Retorna un objeto de tipo libro.
	 */
	@Override
	@Transactional
	public Libro save(Libro libro) {
		return libroDao.save(libro);
	}

	/**
	 * Método de capa de servicio que permite eliminar un libro existente.
	 */
	@Override
	@Transactional
	public void deleteById(Long idLibro) {
		libroDao.deleteById(idLibro);
	}

	/**
	 * Método de capa de servicio que permite guardar un grupo de libros
	 */
	@Override
	@Transactional
	public Iterable<Libro> saveAll(List<Libro> libros) {
		return libroDao.saveAll(libros);
	}

}
