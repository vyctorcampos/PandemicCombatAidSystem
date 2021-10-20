package com.vyctor.pcas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyctor.pcas.domain.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}
