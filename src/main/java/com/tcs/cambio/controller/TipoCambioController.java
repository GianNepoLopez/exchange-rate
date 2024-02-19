package com.tcs.cambio.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.cambio.model.ResultTipoCambio;
import com.tcs.cambio.model.TipoCambio;
import com.tcs.cambio.service.TipoCambioService;

@RestController
@RequestMapping("/tipoCambio")
public class TipoCambioController {

	@Autowired
	private TipoCambioService tipoCambioService;
	
	@GetMapping
	public ResponseEntity<List<TipoCambio>> listarTipoCambio() {
		List<TipoCambio> tipoCambios = tipoCambioService.getAll();
		
		if (tipoCambios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(tipoCambios);
	}
	
	@PostMapping
	public ResponseEntity<TipoCambio> saveTipoCambio(@RequestBody TipoCambio tipoCambio) {
		TipoCambio searchTipoCambio = tipoCambioService.search(tipoCambio.getMonedaOrigen().trim(), tipoCambio.getMonedaDestino().trim());
		TipoCambio newTipoCambio;
		TipoCambio updateTipoCambio;
		
		if (searchTipoCambio != null) {
			updateTipoCambio = tipoCambioService.getTipoCambioById(searchTipoCambio.getIdTipoCambio());
			updateTipoCambio.setValorTipoCambio(tipoCambio.getValorTipoCambio());
			tipoCambioService.save(updateTipoCambio);
			return ResponseEntity.ok(updateTipoCambio);
		} else {
			newTipoCambio = tipoCambioService.save(tipoCambio);
			return ResponseEntity.ok(newTipoCambio);
		}
	}
	
	@GetMapping("/apply")
	public ResponseEntity<ResultTipoCambio> getResult(@RequestBody Map<String, Object> request) {
		TipoCambio searchTipoCambio = tipoCambioService.search(request.get("monedaOrigen").toString().trim(), request.get("monedaDestino").toString().trim());
		ResultTipoCambio resultCambio = new ResultTipoCambio();
		
		if (searchTipoCambio != null) {
			BigDecimal formatMonto = new BigDecimal(request.get("monto").toString().trim());
			BigDecimal formatTipoCambio = new BigDecimal(searchTipoCambio.getValorTipoCambio());
			
			resultCambio.setMonto(Double.parseDouble(request.get("monto").toString().trim()));
			resultCambio.setMontoTipoCambio(formatMonto.divide(formatTipoCambio, 4, RoundingMode.HALF_UP));
			resultCambio.setMonedaOrigen(request.get("monedaOrigen").toString().trim());
			resultCambio.setMonedaDestino(request.get("monedaDestino").toString().trim());
			resultCambio.setValorTipoCambio(searchTipoCambio.getValorTipoCambio());
			return ResponseEntity.ok(resultCambio);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
