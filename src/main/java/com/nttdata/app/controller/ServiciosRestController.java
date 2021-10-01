package com.nttdata.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.nttdata.app.models.entity.DataUser;
import com.nttdata.app.models.entity.Employee;
import com.nttdata.app.models.entity.UserPage;
import com.nttdata.app.models.service.IReqResService;

/**
 * Declaración de clase de servicio, que implementa metodos del proveedor de
 * servicio.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/api")
public class ServiciosRestController {

	/**
	 * Inyección de dependencias
	 */
	@Autowired
	private IReqResService reqRestService;

	/**
	 * Servicio Rest que devuelve una página de datos de tipo usuario.
	 * 
	 * @param page es el número de página que se requiere
	 * @return
	 */
	@GetMapping("/user/page/{page}")
	public ResponseEntity<?> getUsersPage(@PathVariable String page) {
		Map<String, Object> response = new HashMap<>();
		UserPage userPage = new UserPage();
		try {
			if (isInteger(page)) {
				userPage = reqRestService.findByPage(Integer.parseInt(page));
				if (userPage.getData().size() == 0) {
					response.put("message", "Page without user data");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
				}
			} else {
				response.put("message", "Page without user data");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
		} catch (HttpClientErrorException e) {
			response.put("message", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, e.getStatusCode());
		}

		return new ResponseEntity<UserPage>(userPage, HttpStatus.OK);
	}

	/**
	 * Servicio Rest que devuelve un objeto de Usuario, buscado por ID
	 * 
	 * @param idUser es el ID del usuario
	 * @return Objeto de Tipo Usuario.
	 */
	@GetMapping("/user/id/{idUser}")
	public ResponseEntity<?> getUserIdUsuario(@PathVariable String idUser) {
		Map<String, Object> response = new HashMap<>();
		DataUser user = new DataUser();

		try {
			if (isInteger(idUser)) {
				user = reqRestService.findById(Integer.parseInt(idUser));
				if (Objects.isNull(user)) {
					response.put("message", "No user data");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
				}
			} else {
				response.put("message", "No user data");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
		} catch (HttpClientErrorException e) {
			response.put("message", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, e.getStatusCode());
		}

		return new ResponseEntity<DataUser>(user, HttpStatus.OK);
	}

	/**
	 * Servicio Rest que permite registrar un nuevo empleado
	 * 
	 * @param employee es el objeto del nuevo empleado
	 * @return Objeto del empleado registrado
	 */
	@PostMapping("/employee/save")
	public ResponseEntity<?> saveEmployee(@RequestBody(required = false) Employee employee) {
		Map<String, Object> response = new HashMap<>();
		Employee newEmployee = new Employee();

		try {
			if (!Objects.isNull(employee)) {
				newEmployee = reqRestService.saveEmployee(employee);
			} else {
				response.put("message", "Invalid parameters");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
		} catch (HttpClientErrorException e) {
			response.put("message", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, e.getStatusCode());
		}

		return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
	}

	/**
	 * Servicio Rest que permite editar un empleado
	 * 
	 * @param employee   es el objeto del empleado a editar
	 * @param idEmployee es el ID del empleado a editar
	 * @return Objeto del empleado editado
	 */
	@PutMapping("/employee/edit/{idEmployee}")
	public ResponseEntity<?> editEmployee(@RequestBody(required = false) Employee employee,
			@PathVariable String idEmployee) {
		Map<String, Object> response = new HashMap<>();
		Employee editEmployee = new Employee();

		try {
			if (!Objects.isNull(employee) && isInteger(idEmployee)) {
				editEmployee = reqRestService.editEmployee(employee, Integer.parseInt(idEmployee));
			} else {
				response.put("message", "Invalid parameters");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
		} catch (HttpClientErrorException e) {
			response.put("message", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, e.getStatusCode());
		}

		return new ResponseEntity<Employee>(editEmployee, HttpStatus.OK);
	}

	/**
	 * Servicio Rest que elimina un empleado
	 * 
	 * @param idEmployee es el ID del empleado a eliminar
	 */
	@DeleteMapping("/employee/delete/{idEmployee}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String idEmployee) {
		Map<String, Object> response = new HashMap<>();

		try {
			if (isInteger(idEmployee)) {
				if (Integer.parseInt(idEmployee) > 0) {
					reqRestService.deleteEmployee(Integer.parseInt(idEmployee));
					response.put("message", "Successfully removed");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
				} else {
					response.put("message", "Invalid parameter");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
				}

			} else {
				response.put("message", "Invalid parameter");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
		} catch (HttpClientErrorException e) {
			response.put("message", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, e.getStatusCode());
		}

	}

	/**
	 * Método de validación que permite saber si un texto es un número
	 * 
	 * @param numero es el parámetro que se desea comparar
	 * @return TRUE si el párametro es un número o FALSE si entra en excepción
	 */
	private boolean isInteger(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
