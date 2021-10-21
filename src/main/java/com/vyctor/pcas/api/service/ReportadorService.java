package com.vyctor.pcas.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vyctor.pcas.domain.dto.ResourceAverageDto;
import com.vyctor.pcas.domain.model.Hospital;
import com.vyctor.pcas.domain.model.RecursosHosp;

@Service
public class ReportadorService {

	public float[] calcularOcupacaoPaciente(List<Hospital> hospitalList) {
		int highOccupancyCount = 0, lowOccupancyCount = 0;
		float highOccupancyPercentage, lowOccupancyPercentage;
		float[] pacienteValues = new float[2];

		for (int i = 0; i < hospitalList.size(); i++) {
			if (hospitalList.get(i).getOccupancy() > 90) {
				highOccupancyCount++;
			} else {
				lowOccupancyCount++;
			}
		}

		highOccupancyPercentage = (100 * highOccupancyCount) / hospitalList.size();
		lowOccupancyPercentage = (100 * lowOccupancyCount) / hospitalList.size();

		pacienteValues[0] = highOccupancyPercentage;
		pacienteValues[1] = lowOccupancyPercentage;

		return pacienteValues;
	}

	public List<ResourceAverageDto> calculateResourcesAverage(List<RecursosHosp> resourcesList, int hospitalQuant) {
		List<ResourceAverageDto> resourceAverageList = new ArrayList<>();
		// Counters
		int medicoCount = 0, enfermeiroCount = 0, respiradorCount = 0, tomografoCount = 0, ambulanciaCount = 0;

		for (RecursosHosp rsrc : resourcesList) {
			switch (rsrc.getName()) {
			case "Médico":
				medicoCount += rsrc.getQuantity();
				break;
			case "Enfermeiro":
				enfermeiroCount += rsrc.getQuantity();
				break;
			case "Respirador":
				respiradorCount += rsrc.getQuantity();
				break;
			case "Tomógrafo":
				tomografoCount += rsrc.getQuantity();
				break;
			case "Ambulância":
				ambulanciaCount += rsrc.getQuantity();
				break;
			}
		}

		resourceAverageList.add(new ResourceAverageDto("Médico", medicoCount / hospitalQuant));
		resourceAverageList.add(new ResourceAverageDto("Enfermeiro", enfermeiroCount / hospitalQuant));
		resourceAverageList.add(new ResourceAverageDto("Respirador", respiradorCount / hospitalQuant));
		resourceAverageList.add(new ResourceAverageDto("Tomógrafo", tomografoCount / hospitalQuant));
		resourceAverageList.add(new ResourceAverageDto("Ambulância", ambulanciaCount / hospitalQuant));
		return resourceAverageList;

	}

}
