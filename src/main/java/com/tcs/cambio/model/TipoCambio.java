package com.tcs.cambio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoCambio")
public class TipoCambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoCambio;

	private String monedaOrigen;
	private String monedaDestino;
	private Double valorTipoCambio;

	public int getIdTipoCambio() {
		return idTipoCambio;
	}

	public void setIdTipoCambio(int idTipoCambio) {
		this.idTipoCambio = idTipoCambio;
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

	public TipoCambio(int idTipoCambio, String monedaOrigen, String monedaDestino, Double valorTipoCambio) {
		this.idTipoCambio = idTipoCambio;
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
		this.valorTipoCambio = valorTipoCambio;
	}

	public TipoCambio() {
		super();
	}
}
