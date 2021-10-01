package com.nttdata.app.models.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nttdata.app.models.entity.DataUser;
import com.nttdata.app.models.entity.Employee;
import com.nttdata.app.models.entity.UserPage;

@SpringBootTest
class ReqResServiceImplTest {

	@Autowired
	private IReqResService reqresService;

	@Test
	void testFindByPage() {
		UserPage userPage = reqresService.findByPage(4);
		assertNotNull(userPage);
	}

	@Test
	void testFindById() {
		DataUser dataUser = reqresService.findById(1);
		assertTrue(Objects.nonNull(dataUser));

	}

	@Test
	void testSaveEmployee() {
		Employee employee = new Employee();
		employee.setJob("leader");
		employee.setName("Tobias");

		Employee newEmployee = reqresService.saveEmployee(employee);

		assertEquals(employee.getName(), newEmployee.getName());
		assertEquals(employee.getJob(), newEmployee.getJob());
		assertNotNull(newEmployee.getCreatedAt());
		assertNotNull(newEmployee.getId());
	}

	@Test
	void testEditEmployee() {
		Employee employee = new Employee();
		employee.setJob("leader");
		employee.setName("Tobias");

		Employee editEmployee = reqresService.editEmployee(employee, 3);

		assertEquals(employee.getName(), editEmployee.getName());
		assertEquals(employee.getJob(), editEmployee.getJob());
		assertNotNull(editEmployee.getUpdatedAt());

	}

	@Test
	void testDeleteEmployee() {
		reqresService.deleteEmployee(3);
	}

}
