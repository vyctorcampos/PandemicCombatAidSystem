package com.vyctor.pcas.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recursos", schema = "public")
public class RecursosHosp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_id")
	private long resource_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "quantity")
	private int quantity;

	public RecursosHosp(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	//Getters and Setters
	public long getResource_id() {
		return resource_id;
	}

	public void setResource_id(long resource_id) {
		this.resource_id = resource_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
