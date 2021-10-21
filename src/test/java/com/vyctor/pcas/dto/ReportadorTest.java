package com.vyctor.pcas.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.vyctor.pcas.domain.dto.Reportador;

public class ReportadorTest {

	Reportador reportador;

	@Before
	public void setUp() {
		reportador = new Reportador();

	}

	@Test
	public void testGetHighOccupancyRate() {
		float insert = 1.1F;
		reportador.setHighOccupancyRate(insert);
		float valueReturned = reportador.getHighOccupancyRate();
		assertEquals(insert, valueReturned);

	}
}
