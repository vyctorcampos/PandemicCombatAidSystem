package com.vyctor.pcas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.vyctor.pcas.domain.dto.ResourceAverageDto;

public class ResourceAverageDtoTest {

	ResourceAverageDto resourceAverageDto;

	@Before
	public void setUp() {
		resourceAverageDto = new ResourceAverageDto();
	}

	@Test
	public void testGetName() {
		String insert = "Name";
		resourceAverageDto.setName(insert);
		String valueReturned = resourceAverageDto.getName();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetAverage() {
		float insert = 1.1F;
		resourceAverageDto.setAverage(insert);
		float valueReturned = resourceAverageDto.getAverage();
		assertEquals(insert, valueReturned);
	}

}
