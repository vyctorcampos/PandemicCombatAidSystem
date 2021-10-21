package com.vyctor.pcas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vyctor.pcas.api.service.ReportadorService;
import com.vyctor.pcas.domain.dto.Reportador;
import com.vyctor.pcas.domain.dto.ResourceAverageDto;
import com.vyctor.pcas.domain.model.Hospital;
import com.vyctor.pcas.domain.model.RecursosHosp;
import com.vyctor.pcas.domain.model.Transacao;
import com.vyctor.pcas.domain.repository.HospitalRepository;
import com.vyctor.pcas.domain.repository.RecursosHospRepository;
import com.vyctor.pcas.domain.repository.TransacaoRepository;

@RestController
@RequestMapping("/report")
public class ReportadorController {

	@Autowired
	HospitalRepository hospitalRepository;

	@Autowired
	TransacaoRepository transacaoRepository;

	@Autowired
	RecursosHospRepository recursosHospRepository;

	@Autowired
	ReportadorService reportadorService;

	@GetMapping
	public Reportador getReport() {
		List<Hospital> hospitalList = hospitalRepository.findAll();
		List<Transacao> transacaoHistory = transacaoRepository.findAll();
		List<RecursosHosp> recursosHospList = recursosHospRepository.findAll();

		float[] percetagemValue = reportadorService.calcularOcupacaoPaciente(hospitalList);

		List<ResourceAverageDto> resourceAverageList = reportadorService.calculateResourcesAverage(recursosHospList,
				hospitalList.size());

		Reportador report = new Reportador(percetagemValue[0], percetagemValue[1], transacaoHistory,
				resourceAverageList);

		return report;
	}

}
