package com.it.ibm.custofleet;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.ibm.custofleet.service.VinExtractorService;

@SpringBootApplication
public class CustofleetApplication {

    private static final Logger logger = Logger.getLogger(CustofleetApplication.class.getName());

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CustofleetApplication.class, args);
        VinExtractorService service = context.getBean(VinExtractorService.class);

        logger.info("Avvio programma Custofleet");
        try {
            service.process();
        } catch (Exception e) {
            logger.severe("Errore in fase di estrazione VIN: " + e.getMessage());
            e.printStackTrace();
        }
        logger.info("Fine programma Custofleet");
    }
}