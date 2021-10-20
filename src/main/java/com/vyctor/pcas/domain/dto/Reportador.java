package com.vyctor.pcas.domain.dto;

import java.util.List;

import com.vyctor.pcas.domain.model.Transacao;

public class Reportador {

	private float highOccupancyRate;
	
	private float lowOccupancyRate;
	
	private List<Transacao> historicoTransacaos;
	
	private List<ResourceAverageDto> resourceAverageList;
	
	
	public Reportador(float highOccupancyRate, float lowOccupancyRate, List<Transacao> historicoTransacaos,
			List<ResourceAverageDto> resourceAverageList) {
		super();
		setHighOccupancyRate (highOccupancyRate);
		setLowOccupancyRate (lowOccupancyRate);
		setHistoricoTransacaos(historicoTransacaos);
		setResourceAverageList (resourceAverageList);
	}

	public Reportador() {}

	public float getHighOccupancyRate() {
		return highOccupancyRate;
	}

	public void setHighOccupancyRate(float highOccupancyRate) {
		this.highOccupancyRate = highOccupancyRate;
	}

	public float getLowOccupancyRate() {
		return lowOccupancyRate;
	}

	public void setLowOccupancyRate(float lowOccupancyRate) {
		this.lowOccupancyRate = lowOccupancyRate;
	}

	public List<Transacao> getHistoricoTransacaos() {
		return historicoTransacaos;
	}

	public void setHistoricoTransacaos(List<Transacao> historicoTransacaos) {
		this.historicoTransacaos = historicoTransacaos;
	}

	public List<ResourceAverageDto> getResourceAverageList() {
		return resourceAverageList;
	}

	public void setResourceAverageList(List<ResourceAverageDto> resourceAverageList) {
		this.resourceAverageList = resourceAverageList;
	}

}
