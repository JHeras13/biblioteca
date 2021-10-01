package com.nttdata.app.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.app.models.entity.Libro;
import com.nttdata.app.models.service.ILibroService;

/**
 * Declaración de clase de servicio, que implementa metodos del proveedor de
 * servicio.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

@Controller
public class LibroController {
	/**
	 * Inyección de dependencias
	 */
	@Autowired
	private ILibroService libroService;

	/**
	 * Método que permite listar y visualizar todos los libros existentes
	 * 
	 * @param model permite enviar parametros a la vista(MVC)
	 * @return nombre de la vista, es igual al nombre HTML
	 */
	@GetMapping(value = "/listar-libros")
	public String listarLibros(Model model) {
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libroService.findAll());
		return "listar-libros";
	}

	/**
	 * Metodo que permite realizar la busqueda de libros en relación a las
	 * coincidencias de los atributos del objeto libro. Este método se pudo haber
	 * realizado directamente con una consulta, se realizó de esta manera para hacer
	 * uso de Stream.
	 * 
	 * @param model permite enviar parametros a la vista(MVC)
	 * @param q     es el parámetro con se toma para comparar en el filtrado de
	 *              datos
	 * @return nombre de la vista, es igual al nombre HTML
	 */
	@GetMapping(value = "/buscar-libros")
	public String buscarLibros(Model model, @RequestParam String q) {
		List<Libro> libros = new ArrayList<Libro>();
		List<Libro> librosFiltrados = new ArrayList<Libro>();
		libros = libroService.findAll();
		if (!q.isEmpty()) {
			librosFiltrados = libros.stream()
					.filter(libro -> libro.getTitulo().toLowerCase().contains(q.toLowerCase())
							|| libro.getAutor().toLowerCase().contains(q.toLowerCase())
							|| libro.getAnio().toLowerCase().contains(q.toLowerCase())
							|| libro.getEditorial().toLowerCase().contains(q.toLowerCase())
							|| libro.getGenero().toLowerCase().contains(q.toLowerCase())
							|| libro.getId().toString().toLowerCase().contains(q.toLowerCase()))
					.collect(Collectors.toList());

		} else {
			return "redirect:/listar-libros";
		}

		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", librosFiltrados);
		return "listar-libros";
	}

	/**
	 * Método que redirecciona la ruta raiz a el listado de libros
	 * 
	 * @return nombre de la vista, es igual al nombre HTML
	 */

	@GetMapping(value = "/")
	public String inicio() {
		return "redirect:/listar-libros";
	}

	/**
	 * Método que envía el modelo a la vista y el objeto con el cual se podrá
	 * guardar.
	 * 
	 * @param model permite enviar parametros a la vista(MVC)
	 * @return nombre de la vista, es igual al nombre HTML
	 */
	@GetMapping(value = "/nuevo-libro")
	public String nuevoLibro(Map<String, Object> model) {
		Libro libro = new Libro();
		model.put("libro", libro);
		model.put("titulo", "Nuevo libro");
		return "nuevo-libro";
	}

	/**
	 * Método que envía el modelo a la vista y el objeto con el cual se podrá
	 * editar.
	 * 
	 * @param id    del libro que se desea editar.
	 * @param model permite enviar parametros a la vista(MVC)
	 * @return nombre de la vista, es igual al nombre HTML
	 */
	@GetMapping(value = "/nuevo-libro/{id}")
	public String editarLibro(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Libro libro = new Libro();

		if (id > 0) {
			libro = libroService.findById(id);
		} else {
			return "redirect:/listar-libros";
		}

		model.put("libro", libro);
		model.put("titulo", "Editar libro");
		return "nuevo-libro";
	}

	/**
	 * Método que permite eliminar un objeto de libro a travéz del ID
	 * 
	 * @param id del libro que se desea eliminar
	 * @return nombre de la vista a la que se va a redirecionar despues de eliminar,
	 *         es igual al nombre HTML
	 */
	@GetMapping(value = "/eliminar-libro/{id}")
	public String eliminarLibro(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			libroService.deleteById(id);
		}
		return "redirect:/listar-libros";
	}

	/**
	 * Método que guarda o editar un libro.
	 * 
	 * @param libro  es el objeto que se guardara o editara
	 * @param result nos permite validar si el objeto tiene errores antes de ser
	 *               registrado, se declaro en clase entity.
	 * @param model  permite enviar parametros a la vista(MVC)
	 * @return nombre de la vista, es igual al nombre HTML
	 */
	@PostMapping(value = "/nuevo-libro")
	public String guardarLibro(@Valid Libro libro, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo libro");
			return "nuevo-libro";
		}

		libro.setFechaCreacion(Calendar.getInstance());
		libroService.save(libro);
		return "redirect:listar-libros";
	}

	@GetMapping(value = "/guardar-listado-libros")
	public String guardarLibros() {
		List<Libro> libros = new ArrayList<Libro>();

		for (int i = 1; i < 11; i++) {
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

		return "redirect:listar-libros";
	}
}
