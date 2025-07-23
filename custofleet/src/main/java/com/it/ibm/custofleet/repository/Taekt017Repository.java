package com.it.ibm.custofleet.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.ibm.custofleet.entity.Taekt017;

/**
 * Repository JPA per accesso alla tabella TAEKT017.
 */
public interface Taekt017Repository extends JpaRepository<Taekt017, String> {

	/**
	 * Estrae i VIN mai inviati all’API (C_DATETIME_REQUEST_API IS NULL) per un dato
	 * mercato.
	 *
	 * @param mercato  Il codice mercato
	 * @param pageable Parametro per il paging
	 * @return Lista di VIN mai inviati
	 */
	@Query("""
			    SELECT t
			    FROM Taekt017 t
			    WHERE t.cDatetimeRequestApi IS NULL
			      AND t.cMercato = :mercato
			""")
	List<Taekt017> findNeverSentByMercato(@Param("mercato") String mercato, Pageable pageable);

	/**
	 * Estrae i VIN mai inviati e con errore precedente (C_RESPONSE_CODE ≠ '200')
	 * per un dato mercato.
	 *
	 * @param mercato  Il codice mercato
	 * @param pageable Parametro per il paging
	 * @return Lista di VIN da riprocessare per errore
	 */
	@Query("""
			    SELECT t
			    FROM Taekt017 t
			    WHERE t.cDatetimeRequestApi IS NULL
			      AND t.cMercato = :mercato
			      AND t.cResponseCode <> '200'
			""")
	List<Taekt017> findWithErrorByMercato(@Param("mercato") String mercato, Pageable pageable);

}