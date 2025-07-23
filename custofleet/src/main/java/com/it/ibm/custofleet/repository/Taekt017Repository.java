package com.it.ibm.custofleet.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.ibm.custofleet.entity.Taekt017;

/**
 * Repository JPA per accesso alla tabella TAEKT017
 */
public interface Taekt017Repository extends JpaRepository<Taekt017, String> {

    @Query("SELECT t FROM Taekt017 t WHERE t.flStatusPersn = 'E' AND t.datetimeRequestApi IS NULL AND t.mercato = :mercato")
    List<Taekt017> findPendingByMarket(@Param("mercato") String mercato, Pageable pageable);
}