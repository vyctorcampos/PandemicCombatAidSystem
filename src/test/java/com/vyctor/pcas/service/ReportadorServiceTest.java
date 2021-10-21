package com.vyctor.pcas.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.vyctor.pcas.api.service.ReportadorService;
import com.vyctor.pcas.domain.dto.ResourceAverageDto;
import com.vyctor.pcas.domain.model.Hospital;
import com.vyctor.pcas.domain.model.RecursosHosp;

public class ReportadorServiceTest {

	ReportadorService reportadorService;
	List<Hospital> hospitalList;
	List<RecursosHosp> recursosHosps;
	List<ResourceAverageDto> resourceAverageTest;

	@Before
	public void setUp() {

		RecursosHosp res1, res2;

		res1 = new RecursosHosp("Médico", 1);
		res2 = new RecursosHosp("Enfermeiro", 2);

		// Lista de recursos

		recursosHosps = new ArrayList<>();
		recursosHosps.add(res1);
		recursosHosps.add(res2);

		// hospital list

		hospitalList = new ArrayList<Hospital>();
		hospitalList.add(
				new Hospital(1L, "TestName1", "TestAddress1", "TestCnpj1", 1F, "TestLocalization1", recursosHosps));
		hospitalList.add(
				new Hospital(2L, "TestName2", "TestAddress2", "TestCnpj2", 99F, "TestLocalization2", recursosHosps));

		// media de recursos

		resourceAverageTest = new ArrayList<>();
		resourceAverageTest.add(new ResourceAverageDto("Médico", 1));
		resourceAverageTest.add(new ResourceAverageDto("Enfermeiro", 2));
		resourceAverageTest.add(new ResourceAverageDto("Respirador", 0));
		resourceAverageTest.add(new ResourceAverageDto("Tomógrafo", 0));
		resourceAverageTest.add(new ResourceAverageDto("Ambulância", 0));

		reportadorService = new ReportadorService();
	}

	@Test
	public void testCalculateOccupancyPercentage() {
		float[] insert = { 50F, 50F };
		float[] valueReturned = reportadorService.calcularOcupacaoPaciente(hospitalList);
		assertArrayEquals(insert, valueReturned);
	}

	@Test
	public void testCalculateResourcesAverage() {
		List<ResourceAverageDto> valueReturned = reportadorService.calculateResourcesAverage(recursosHosps, 1);
		for (int i = 0; i < valueReturned.size(); i++) {
			assertEquals(resourceAverageTest.get(i).getName(), valueReturned.get(i).getName());
			assertEquals(resourceAverageTest.get(i).getAverage(), valueReturned.get(i).getAverage());
		}

	}
}
