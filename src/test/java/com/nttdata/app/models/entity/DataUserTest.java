package com.nttdata.app.models.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataUserTest {

	@Test
	void testGetData() {
		DataUser dataUser = new DataUser();

		assertEquals(new DataUser().getData(), dataUser.getData());
	}

}
