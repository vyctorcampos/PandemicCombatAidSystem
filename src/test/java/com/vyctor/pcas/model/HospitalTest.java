package com.vyctor.pcas.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vyctor.pcas.domain.model.Hospital;
import com.vyctor.pcas.domain.model.RecursosHosp;

public class HospitalTest {

	private Hospital hospital;

	@Before
	public void setUp() {
		hospital = new Hospital(0, null, null, null, 0, null, null);
	}

	@Test
	public void testGetHospitalId() {
		Long insert = 1L;
		hospital.setHospital_id(insert);
		Long valueReturned = hospital.getHospital_id();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetName() {
		String insert = "Name";
		hospital.setName(insert);
		String valueReturned = hospital.getName();
		assertEquals(insert, valueReturned);

	}

	@Test
	public void testGetAddress() {
		String insert = "Address";
		hospital.setAddress(insert);
		String valueReturned = hospital.getAddress();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetCnpj() {
		String insert = "Cnpj";
		hospital.setCnpj(insert);
		String valueReturned = hospital.getCnpj();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetLocalization() {
		String insert = "Localization";
		hospital.setLocalization(insert);
		String valueReturned = hospital.getLocalization();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testOccupancy() {
		float insert = 1.1F;
		hospital.setOccupancy(insert);
		float valueReturned = hospital.getOccupancy();
		Float.compare(insert, valueReturned);
	}

	@Test
	public void testResources() {
		List<RecursosHosp> insert = new ArrayList<>();
		hospital.setRecursosHosp(insert);
		List<RecursosHosp> valueReturned = hospital.getRecursosHosp();
		assertEquals(insert, valueReturned);
	}

}
