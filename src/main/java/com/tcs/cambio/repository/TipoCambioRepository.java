package com.tcs.cambio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.cambio.model.TipoCambio;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {

	@Query("SELECT NEW com.tcs.cambio.model.TipoCambio(T1.idTipoCambio, T1.monedaOrigen, T1.monedaDestino, T1.valorTipoCambio) FROM TipoCambio T1 "
			+ "WHERE T1.monedaOrigen LIKE %?1% AND T1.monedaDestino LIKE %?2%")
	TipoCambio searchTipoCambio(String monedaOrigen, String monedaDestino);
}
