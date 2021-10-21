package com.vyctor.pcas.domain.dto;

public class ResourceAverageDto {

	private String name;
	private float average;

	public ResourceAverageDto() {
	}

	public ResourceAverageDto(String name, float average) {
		super();
		this.name = name;
		this.average = average;
	}

	// getter e setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

}
