package com.vyctor.pcas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vyctor.pcas.domain.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
