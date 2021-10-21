package com.vyctor.pcas.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.vyctor.pcas.domain.model.Resources;

public class ResourcesTest {

	Resources resources;

	@Before
	public void setUp() {
		resources = new Resources();
	}

	@Test
	public void testGetName() {
		String insert = "Name";
		resources.setName(insert);
		String valueReturned = resources.getName();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetValue() {
		int insert = 1;
		resources.setValue(insert);
		int valueReturned = resources.getValue();
		assertEquals(insert, valueReturned);
	}

}
