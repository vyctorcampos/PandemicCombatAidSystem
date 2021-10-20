package com.vyctor.pcas.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vyctor.pcas.domain.dto.OccupancyHosp;
import com.vyctor.pcas.domain.model.Hospital;
import com.vyctor.pcas.domain.repository.HospitalRepository;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalRepository hospitalRepository;

	@GetMapping
	public List<Hospital> getHospitalsList() {
		return hospitalRepository.findAll();
	}

	@GetMapping("/{hospitalId}")
	public ResponseEntity<Hospital> getHospital(@PathVariable Long hospital_id) {
		Optional<Hospital> hospital = hospitalRepository.findById(hospital_id);
		if (hospital.isPresent()) {
			return ResponseEntity.ok(hospital.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Hospital postHospital(@RequestBody Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@PatchMapping("/{hospitalId}")
	public ResponseEntity<Hospital> patchOccupancyHosp(@RequestBody OccupancyHosp ocupacaoHosp,
			@PathVariable Long hospitalId) {
		Optional<Hospital> hospital = hospitalRepository.findById(hospitalId);
		if (hospital.isPresent()) {
			hospital.get().setOccupancy(ocupacaoHosp.getOccupancy());
			hospitalRepository.save(hospital.get());
			return ResponseEntity.ok(hospital.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
