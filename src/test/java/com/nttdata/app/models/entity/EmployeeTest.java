package com.nttdata.app.models.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void testGetId() {
		Employee employee = new Employee();
		String id = "173";
		employee.setId(id);

		assertTrue(id == employee.getId());
	}

	@Test
	void testSetId() {
		Employee employee = new Employee();
		String id = "173";
		employee.setId(id);

		assertTrue(id == employee.getId());
	}

	@Test
	void testGetName() {
		Employee employee = new Employee();
		String name = "Michael";
		employee.setName(name);

		assertEquals(name, employee.getName());
	}

	@Test
	void testSetName() {
		Employee employee = new Employee();
		String name = "Michael";
		employee.setName(name);

		assertTrue(name.equals(employee.getName()));
	}

	@Test
	void testGetJob() {
		Employee employee = new Employee();
		String job = "leader";
		employee.setJob(job);

		assertEquals(job, employee.getJob());
	}

	@Test
	void testSetJob() {
		Employee employee = new Employee();
		String job = "leader";
		employee.setJob(job);

		assertTrue(job.equals(employee.getJob()));
	}

	@Test
	void testGetCreatedAt() {
		Employee employee = new Employee();
		Calendar c = Calendar.getInstance();

		assertNotEquals(c, employee.getCreatedAt());
	}

	@Test
	void testGetUpdatedAt() {
		Employee employee = new Employee();
		Calendar c = Calendar.getInstance();

		assertNotEquals(c, employee.getUpdatedAt());
	}

}
