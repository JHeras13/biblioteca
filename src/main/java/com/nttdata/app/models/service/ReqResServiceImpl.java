package com.nttdata.app.models.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.nttdata.app.models.entity.DataUser;
import com.nttdata.app.models.entity.Employee;
import com.nttdata.app.models.entity.UserPage;

/**
 * Declaración de clase de servicio, que implementa métodos del comportamiento
 * de IReqResService
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

@Service
public class ReqResServiceImpl implements IReqResService {

	/**
	 * Inyección de dependencias
	 */
	@Autowired
	private RestTemplate clientRest;

	/**
	 * EndPoint
	 */
	private final String domain = "https://reqres.in/api";

	/**
	 * Método que cliente HTTP, el cual obtiene una página de datos de tipo usuario
	 * 
	 * @param page es el número de página que se requiere
	 * @return Objeto de tipo página de usuario
	 */
	@Override
	@Transactional(readOnly = true)
	public UserPage findByPage(int page) {

		UserPage pageUser = clientRest.getForObject(domain.concat("/users?page=").concat(String.valueOf(page)),
				UserPage.class);
		return pageUser;
	}

	@Override
	@Transactional(readOnly = true)
	public DataUser findById(int idUser) {

		ResponseEntity<DataUser> response = clientRest.exchange(domain.concat("/users/").concat(String.valueOf(idUser)),
				HttpMethod.GET, null, DataUser.class);

		DataUser dataUser = response.getBody();
		return dataUser;
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		HttpEntity<Employee> body = new HttpEntity<Employee>(employee);

		ResponseEntity<Employee> response = clientRest.exchange(domain.concat("/users"), HttpMethod.POST, body,
				Employee.class);
		return response.getBody();
	}

	@Override
	@Transactional
	public Employee editEmployee(Employee employee, int idEmployee) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", String.valueOf(idEmployee));

		HttpEntity<Employee> body = new HttpEntity<Employee>(employee);

		ResponseEntity<Employee> response = clientRest.exchange(domain.concat("/users/{id}"), HttpMethod.PUT, body,
				Employee.class, pathVariables);
		return response.getBody();
	}

	@Override
	@Transactional
	public void deleteEmployee(int idEmployee) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", String.valueOf(idEmployee));

		clientRest.exchange(domain.concat("/users/{id}"), HttpMethod.DELETE, null, Employee.class, pathVariables);
	}

}
