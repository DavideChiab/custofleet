package com.it.ibm.custofleet.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.it.ibm.custofleet.entity.Taekt017;
import com.it.ibm.custofleet.repository.Taekt017Repository;

/**
 * Servizio che estrae i VIN da elaborare dalla tabella TAEKT017
 */
@Service
public class VinExtractorService {

    private static final Logger logger = LogManager.getLogger(VinExtractorService.class);

    @Value("${custofleet.batch.size:100}")
    private int batchSize;

    @Value("${custofleet.mercato}")
    private String mercato;

    private final Taekt017Repository repository;

    public VinExtractorService(Taekt017Repository repository) {
        this.repository = repository;
    }

    /**
     * Estrae e logga i VIN da processare
     */
    public void process() {
        logger.info("Start VIN extraction for market: " + mercato + ", batch size: " + batchSize);
        Pageable limit = PageRequest.of(0, batchSize);
        List<Taekt017> records = repository.findNeverSentByMercato(mercato, limit);

        for (Taekt017 record : records) {
            logger.info("VIN trovato: " + record.getCVin());
        }
    }
}