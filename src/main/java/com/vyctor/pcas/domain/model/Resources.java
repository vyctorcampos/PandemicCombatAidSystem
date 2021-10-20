package com.vyctor.pcas.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resources {

	
	@Id
	private String name;
	
	public String getName() {
		return name;
	}

	//Getters and Setters
	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private int value;
	
}
