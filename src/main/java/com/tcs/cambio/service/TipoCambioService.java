package com.tcs.cambio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.cambio.model.TipoCambio;
import com.tcs.cambio.repository.TipoCambioRepository;

@Service
public class TipoCambioService {

	@Autowired
	private TipoCambioRepository tipoCambioRepository;
	
	public List<TipoCambio> getAll() {
		return tipoCambioRepository.findAll();
	}
	
	public TipoCambio getTipoCambioById(int id) {
		return tipoCambioRepository.findById(id).orElse(null);
	}
	
	public TipoCambio search(String monedaOrigen, String monedaDestino) {
		TipoCambio searchTipoCambio = tipoCambioRepository.searchTipoCambio(monedaOrigen.trim(), monedaDestino.trim());
		return searchTipoCambio;
	}
	
	public TipoCambio save(TipoCambio tipoCambio) {
		TipoCambio newTipoCambio = tipoCambioRepository.save(tipoCambio);
		return newTipoCambio;
	}
}
