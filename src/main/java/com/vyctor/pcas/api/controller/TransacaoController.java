package com.vyctor.pcas.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vyctor.pcas.api.service.NegociacaoService;
import com.vyctor.pcas.domain.model.Transacao;
import com.vyctor.pcas.domain.repository.TransacaoRepository;

@RestController
@RequestMapping("/negotiation")
public class TransacaoController {

	@Autowired
	TransacaoRepository transacaoRepository;
	
	@Autowired
	NegociacaoService negociacaoService;
	
	@GetMapping
	public List<Transacao> getTransacaoList(){
		return transacaoRepository.findAll();
	}
	
	@PostMapping
	public Transacao postTransacao(@RequestBody Transacao transacao) {
		transacao.setNegotiation_date_time(LocalDateTime.now());
		negociacaoService.negociar(transacao);
		return transacaoRepository.save(transacao);
	}
	
	
	
	
}
