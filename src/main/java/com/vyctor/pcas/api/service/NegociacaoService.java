package com.vyctor.pcas.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.RejectedExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vyctor.pcas.domain.model.Hospital;
import com.vyctor.pcas.domain.model.RecursosHosp;
import com.vyctor.pcas.domain.model.Resources;
import com.vyctor.pcas.domain.model.Transacao;
import com.vyctor.pcas.domain.repository.HospitalRepository;
import com.vyctor.pcas.domain.repository.ResourcesRepository;
import com.vyctor.pcas.domain.repository.TransacaoRepository;

@Service
public class NegociacaoService {

	@Autowired
	HospitalRepository hospitalRepository;

	@Autowired
	ResourcesRepository resourcesRepository;

	@Autowired
	TransacaoRepository transacaoRepository;

	public void negociar(Transacao transacao) {
		Optional<Hospital> firstHospital = hospitalRepository.findById(transacao.getId_first_hospital());
		Optional<Hospital> secondHospital = hospitalRepository.findById(transacao.getId_second_hospital());

		List<Resources> resources = resourcesRepository.findAll();
		compareValues(transacao, firstHospital.get(), secondHospital.get(), resources);

	}

	private void compareValues(Transacao transacao, Hospital hospital1, Hospital hospital2, List<Resources> resources) {
		int valueFirstHospital = 0, valueSecondHospital = 0;
		List<RecursosHosp> recursoFirstHospital = transacao.getResources_first_hospital();
		List<RecursosHosp> recursosecondHospital = transacao.getResources_second_hospital();

		for (RecursosHosp recursosHosp : recursoFirstHospital) {
			for (Resources rsrc : resources) {
				if (recursosHosp.getName().toUpperCase().equals(rsrc.getName())) {
					valueFirstHospital += (rsrc.getValue() * recursosHosp.getQuantity());
				}
			}
		}

		for (RecursosHosp recursosHosp : recursoFirstHospital) {
			for (Resources rsrc : resources) {
				if (recursosHosp.getName().toUpperCase().equals(rsrc.getName())) {
					valueFirstHospital += (rsrc.getValue() * recursosHosp.getQuantity());
				}
			}
		}

		for (RecursosHosp recursosHosp : recursosecondHospital) {
			for (Resources rsrc : resources) {
				if (recursosHosp.getName().toUpperCase().equals(rsrc.getName())) {
					valueSecondHospital += (rsrc.getValue() * recursosHosp.getQuantity());
				}
			}
		}
		// comparar valores
		if (valueFirstHospital < valueSecondHospital) {
			if (hospital1.getOccupancy() > 90) {
				trade(hospital1, hospital2, transacao);

			} else {
				throw new RejectedExecutionException(hospital1.getName());
			}
		} else {
			trade(hospital1, hospital2, transacao);
		}
	}
	

	private void trade(Hospital hospital1, Hospital hospital2, Transacao transacao) {

		List<RecursosHosp> recursoFirstHospital = transacao.getResources_first_hospital();
		List<RecursosHosp> recursoSecondHospital = transacao.getResources_second_hospital();

		// remover
		List<RecursosHosp> removerRecursos1 = new ArrayList<>();
		List<RecursosHosp> removerRecursos2 = new ArrayList<>();

		// add
		List<RecursosHosp> addRecursos1 = new ArrayList<>();
		addRecursos1.addAll(recursoSecondHospital);
		List<RecursosHosp> addRecursos2 = new ArrayList<>();
		addRecursos2.addAll(recursoFirstHospital);

		for (RecursosHosp transacaoRecurso : recursoFirstHospital) {
			
			//quantidade de recursos do primeiro hospital
			for (RecursosHosp recursoshsptlHosp : hospital1.getRecursosHosp()) {
				if (recursoshsptlHosp.getName().equals(transacaoRecurso.getName())) {
					if (recursoshsptlHosp.getQuantity() == transacaoRecurso.getQuantity()) {
						removerRecursos1.add(recursoshsptlHosp);
					} else {
						recursoshsptlHosp.setQuantity(recursoshsptlHosp.getQuantity() - transacaoRecurso.getQuantity());
					}

				}
			}
			// mais quantidade de recursos de segundo hospital
			for(RecursosHosp hospitalRecursos: hospital2.getRecursosHosp()) {
				if (hospitalRecursos.getName().equals(transacaoRecurso.getName())) {
					hospitalRecursos.setQuantity(hospitalRecursos.getQuantity() + transacaoRecurso.getQuantity());
					addRecursos2.remove(transacaoRecurso);
					
				}
			}
		}
		
		for (RecursosHosp transacaoRecurso : recursoFirstHospital) {
			
		for (RecursosHosp recursoshsptlHosp : hospital2.getRecursosHosp()) {
			if (recursoshsptlHosp.getName().equals(transacaoRecurso.getName())) {
				if (recursoshsptlHosp.getQuantity() == transacaoRecurso.getQuantity()) {
						removerRecursos2.add(recursoshsptlHosp);
				}else {
					recursoshsptlHosp.setQuantity(recursoshsptlHosp.getQuantity() - transacaoRecurso.getQuantity());
				}
				
			}
		}
		for (RecursosHosp recursoshsptlHosp : hospital1.getRecursosHosp()) {
			if (recursoshsptlHosp.getName().equals(transacaoRecurso.getName())) {
				
				recursoshsptlHosp.setQuantity(recursoshsptlHosp.getQuantity() + transacaoRecurso.getQuantity());
				addRecursos1.remove(transacaoRecurso);
			}
		}
	}
		//add
	hospital1.getRecursosHosp().addAll(addRecursos1);	
	
	hospital2.getRecursosHosp().addAll(addRecursos2);	
		
	// delete
	hospital1.getRecursosHosp().removeAll(removerRecursos1);
	hospital2.getRecursosHosp().removeAll(removerRecursos2);	
	
	hospitalRepository.save(hospital1);
	hospitalRepository.save(hospital2);	
			
	}
}

