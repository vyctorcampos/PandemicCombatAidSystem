package com.vyctor.pcas.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.vyctor.pcas.domain.model.RecursosHosp;

public class RecursosHospTest {

	RecursosHosp recursosHosp;

	@Before
	public void setUp() {
		recursosHosp = new RecursosHosp(null, 0);
	}

	@Test
	public void testGetResourceId() {
		Long insert = 1L;
		recursosHosp.setResource_id(insert);
		Long valueReturned = recursosHosp.getResource_id();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetName() {
		String insert = "Name";
		recursosHosp.setName(insert);
		String valueReturned = recursosHosp.getName();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetQuantity() {
		int insert = 1;
		recursosHosp.setQuantity(insert);
		int valueReturned = recursosHosp.getQuantity();
		assertEquals(insert, valueReturned);
	}

}
