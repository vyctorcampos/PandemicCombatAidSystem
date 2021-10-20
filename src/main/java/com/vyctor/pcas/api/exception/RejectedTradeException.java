package com.vyctor.pcas.api.exception;

public class RejectedTradeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RejectedTradeException(String hospitalName) {
		super("Intercâmbio rejeitado. Custo de " + hospitalName + " menor.");
	}
	
}