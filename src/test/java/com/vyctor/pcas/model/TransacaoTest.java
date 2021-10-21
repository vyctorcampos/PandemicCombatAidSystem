package com.vyctor.pcas.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vyctor.pcas.domain.model.RecursosHosp;
import com.vyctor.pcas.domain.model.Transacao;

public class TransacaoTest {

	Transacao transacao;

	@Before
	public void setUp() {
		transacao = new Transacao();

	}

	@Test
	public void testGetNegotiationId() {
		Long insert = 1L;
		transacao.setNegotiation_id(insert);
		Long valueReturned = transacao.getNegotiation_id();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetId_first_hospital() {
		Long insert = 1L;
		transacao.setId_first_hospital(insert);
		Long valueReturned = transacao.getId_first_hospital();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetId_second_hospital() {
		Long insert = 1L;
		transacao.setId_second_hospital(insert);
		Long valueReturned = transacao.getId_second_hospital();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetNegotiation_date_time() {
		LocalDateTime insert = LocalDateTime.now();
		transacao.setNegotiation_date_time(insert);
		LocalDateTime valueReturned = transacao.getNegotiation_date_time();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetResources_first_hospital() {
		List<RecursosHosp> insert = new ArrayList<>();
		transacao.setResources_first_hospital(insert);
		List<RecursosHosp> valueReturned = transacao.getResources_first_hospital();
		assertEquals(insert, valueReturned);
	}

	@Test
	public void testGetResources_second_hospital() {
		List<RecursosHosp> insert = new ArrayList<>();
		transacao.setResources_second_hospital(insert);
		List<RecursosHosp> valueReturned = transacao.getResources_second_hospital();
		assertEquals(insert, valueReturned);
	}
}
