package com.vyctor.pcas.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long negotiation_id;

	private Long id_first_hospital;

	private Long id_second_hospital;

	private LocalDateTime negotiation_date_time;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "negotiation_resource_join_table", joinColumns = @JoinColumn(name = "negotiation_RH"), inverseJoinColumns = @JoinColumn(name = "hospital_resource_RH"))
	private List<RecursosHosp> resources_first_hospital;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "negotiation_resource_join_table", joinColumns = @JoinColumn(name = "negotiation_RH"), inverseJoinColumns = @JoinColumn(name = "hospital_resource_RH"))
	private List<RecursosHosp> resources_second_hospital;

	public long getNegotiation_id() {
		return negotiation_id;
	}

	public void setNegotiation_id(long negotiation_id) {
		this.negotiation_id = negotiation_id;
	}

	public Long getId_first_hospital() {
		return id_first_hospital;
	}

	public void setId_first_hospital(Long id_first_hospital) {
		this.id_first_hospital = id_first_hospital;
	}

	public Long getId_second_hospital() {
		return id_second_hospital;
	}

	public void setId_second_hospital(Long id_second_hospital) {
		this.id_second_hospital = id_second_hospital;
	}

	public LocalDateTime getNegotiation_date_time() {
		return negotiation_date_time;
	}

	public void setNegotiation_date_time(LocalDateTime negotiation_date_time) {
		this.negotiation_date_time = negotiation_date_time;
	}

	public List<RecursosHosp> getResources_first_hospital() {
		return resources_first_hospital;
	}

	public void setResources_first_hospital(List<RecursosHosp> resources_first_hospital) {
		this.resources_first_hospital = resources_first_hospital;
	}

	public List<RecursosHosp> getResources_second_hospital() {
		return resources_second_hospital;
	}

	public void setResources_second_hospital(List<RecursosHosp> resources_second_hospital) {
		this.resources_second_hospital = resources_second_hospital;
	}

}
