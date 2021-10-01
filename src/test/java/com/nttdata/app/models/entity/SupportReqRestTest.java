package com.nttdata.app.models.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SupportReqRestTest {

	@Test
	void testGetUrl() {
		SupportReqRest s = new SupportReqRest();
		String url = "https://reqres.in/";
		s.setUrl(url);

		assertEquals(url, s.getUrl());
	}

	@Test
	void testSetUrl() {
		SupportReqRest s = new SupportReqRest();
		String url = "https://reqres.in/";
		s.setUrl(url);

		assertEquals(url, s.getUrl());
	}

	@Test
	void testGetText() {
		SupportReqRest s = new SupportReqRest();
		String text = "To keep ReqRes free";
		s.setText(text);

		assertEquals(text, s.getText());
	}

	@Test
	void testSetText() {
		SupportReqRest s = new SupportReqRest();
		String text = "To keep ReqRes free";
		s.setText(text);

		assertEquals(text, s.getText());
	}

}
