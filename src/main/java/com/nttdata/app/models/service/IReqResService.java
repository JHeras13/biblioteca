package com.nttdata.app.models.service;

import com.nttdata.app.models.entity.DataUser;
import com.nttdata.app.models.entity.Employee;
import com.nttdata.app.models.entity.UserPage;

/**
 * Declaración de metodos de comportamiento de ReqRes.
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

public interface IReqResService {

	/**
	 * Método que obtiene una página de datos de tipo usuario.
	 * 
	 * @param page es el número de página que se requiere
	 * @return Objeto de tipo página de usuario
	 */
	public UserPage findByPage(int page);

	/**
	 * Método que permite buscar usuario por ID
	 * 
	 * @param idUser es el ID del usuario que quire obtener
	 * @return Objeto de tipo usuario
	 */
	public DataUser findById(int idUser);

	/**
	 * Método que permite registrar un nuevo empleado
	 * 
	 * @param Employee objeto de empleado nuevo
	 * @return Objeto del nuevo empledo.
	 */
	public Employee saveEmployee(Employee employee);

	/**
	 * Método que permite editar un nuevo empleado
	 * 
	 * @param Employee objeto de empleado que se desea editar
	 * @return Objeto del empledo editado.
	 */
	public Employee editEmployee(Employee employee, int idEmployee);

	/**
	 * Método que permite eliminar un empleado
	 * 
	 * @param idEmployee es el ID del empleado a eliminar
	 */
	public void deleteEmployee(int idEmployee);
}
