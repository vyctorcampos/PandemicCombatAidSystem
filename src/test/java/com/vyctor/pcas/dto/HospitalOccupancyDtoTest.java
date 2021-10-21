package com.vyctor.pcas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.vyctor.pcas.domain.dto.OccupancyHosp;

public class HospitalOccupancyDtoTest {

	OccupancyHosp occupancyHosp;

	@Before
	public void setUp() {
		occupancyHosp = new OccupancyHosp();
	}

	@Test
	public void testGetOccupancy() {
		float insert = 1.1F;
		occupancyHosp.setOccupancy(insert);
		float valueReturned = occupancyHosp.getOccupancy();
		assertEquals(insert, valueReturned);
	}

}
