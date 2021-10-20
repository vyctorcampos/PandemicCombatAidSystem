package com.vyctor.pcas.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "hospital", schema = "public")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hospital_id")
	private long hospital_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "occupancy")
	private float occupancy;
	
	@Column(name = "localization")
	private String localization;
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "negotiation_resource_join_table",
	joinColumns = @JoinColumn(name = "negotiation_RH"),
	   inverseJoinColumns = @JoinColumn (name = "hospital_resource_RH"))
	private List<RecursosHosp> recursosHosp;
	
	public Hospital(long hospital_id, String name, String address, String cnpj, float occupancy, String localization,
			List<RecursosHosp> recursosHosp) {
		super();
		this.hospital_id = hospital_id;
		this.name = name;
		this.address = address;
		this.cnpj = cnpj;
		this.occupancy = occupancy;
		this.localization = localization;
		this.recursosHosp = recursosHosp;
	}

	public long getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(long hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RecursosHosp> getRecursosHosp() {
		return recursosHosp;
	}

	public void setRecursosHosp(List<RecursosHosp> recursosHosp) {
		this.recursosHosp = recursosHosp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public float getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(Float occupancy) {
		this.occupancy = occupancy;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + (int) (hospital_id ^ (hospital_id >>> 32));
		result = prime * result + ((localization == null) ? 0 : localization.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(occupancy);
		result = prime * result + ((recursosHosp == null) ? 0 : recursosHosp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (hospital_id != other.hospital_id)
			return false;
		if (localization == null) {
			if (other.localization != null)
				return false;
		} else if (!localization.equals(other.localization))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(occupancy) != Float.floatToIntBits(other.occupancy))
			return false;
		if (recursosHosp == null) {
			if (other.recursosHosp != null)
				return false;
		} else if (!recursosHosp.equals(other.recursosHosp))
			return false;
		return true;
	}

	public static Object get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
