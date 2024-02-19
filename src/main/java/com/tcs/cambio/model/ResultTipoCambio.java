package com.tcs.cambio.model;

import java.math.BigDecimal;

public class ResultTipoCambio {

	private Double monto;
	private BigDecimal montoTipoCambio;
	private String monedaOrigen;
	private String monedaDestino;
	private Double valorTipoCambio;

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public BigDecimal getMontoTipoCambio() {
		return montoTipoCambio;
	}

	public void setMontoTipoCambio(BigDecimal montoTipoCambio) {
		this.montoTipoCambio = montoTipoCambio;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public Double getValorTipoCambio() {
		return valorTipoCambio;
	}

	public void setValorTipoCambio(Double valorTipoCambio) {
		this.valorTipoCambio = valorTipoCambio;
	}

	public ResultTipoCambio() {
		super();
	}
}
