# Custofleet – Persistenza Locale e Tracciamento VIN

Questo modulo gestisce la ricezione e la tracciabilità delle risposte dell'API Vehicle Invoice (Custofleet) per ogni VIN personalizzato. È costituito da due tabelle:

* TAEKT017: Tabella master VIN – tracciamento stato invio e risposta API
* TAEKT018: Tabella dettaglio voci di personalizzazione associate al VIN

## TAEKT017 – Tabella Status Personalization

Contiene un record per ogni VIN da inviare all’API Custofleet. La selezione è guidata da:

* Assenza di C\_DATETIME\_REQUEST\_API
* C\_MERCATO = codice usato per filtro SQL (es. 1000 per Italia)

Una volta completata l'elaborazione dei VIN nuovi, si procede con quelli che hanno `C_RESPONSE_CODE` diverso da 200 (non andati a buon fine).

### Campi

| Campo                     | Tipo          | Note                                        |
| ------------------------- | ------------- | ------------------------------------------- |
| C\_VIN                    | CHAR(17)      | Primary Key                                 |
| C\_FL\_STATUS\_PERSN      | CHAR(1)       | 'E' o 'C' (End/Cancelled)                   |
| C\_DATE\_END\_PERSN       | CHAR(8)       | Se FL = E                                   |
| C\_DATE\_CANC\_PERSN      | CHAR(8)       | Se FL = C                                   |
| C\_DATETIME\_INS\_UPD     | CHAR(14)      | Data/Ora inserimento o update               |
| C\_CALL\_ID               | VARCHAR2(36)  | UUID per tracciabilità batch                |
| C\_DATETIME\_REQUEST\_API | CHAR(14)      | Timestamp chiamata API (settato in runtime) |
| C\_ESITO\_API             | VARCHAR2(255) | Eventuale messaggio esito                   |
| C\_MERCATO                | CHAR(4)       | Es. '1000' per IT – usato per filtro SQL    |
| C\_RETURN\_CODE           | CHAR(1)       | 0 = OK, 1 = VIN sconosciuto                 |
| C\_RESPONSE\_CODE         | CHAR(3)       | HTTP code della risposta API                |

Solo i VIN con C\_RESPONSE\_CODE = 200 sono considerati elaborati correttamente e non verranno più riprocessati.

## TAEKT018 – Dettaglio Voci Personalizzazione

Contiene una riga per ogni entry nel personalization\_list restituito per ciascun VIN. Il dettaglio include: codici, descrizioni multilingua, prezzi, valuta e riferimenti tecnici per tracciamento batch.

### Campi

| Campo                  | Tipo         | Note                                |
| ---------------------- | ------------ | ----------------------------------- |
| C\_VIN                 | CHAR(17)     | FK verso TAEKT017 – PK (1/3)        |
| C\_COD\_PERSN          | CHAR(15)     | Codice personalizzazione – PK (2/3) |
| C\_DESC\_PERSN         | CHAR(20)     | Descrizione                         |
| C\_COD\_LANGUAGE       | CHAR(2)      | Lingua descrizione – PK (3/3)       |
| C\_VALUE\_PERSN\_PLANT | NUMBER(13,2) | Prezzo INDUSTRIAL (OEM)             |
| C\_VALUE\_PERSN\_IC    | NUMBER(13,2) | Prezzo INTERCOMPANY                 |
| C\_VALUE\_PERSN\_SALE  | NUMBER(13,2) | Prezzo DEALER                       |
| C\_CURRENCY            | CHAR(3)      | Valuta ISO (es. EUR, USD)           |
| C\_DATETIME\_INS\_UPD  | CHAR(14)     | Data/Ora inserimento o update       |

## Relazione tra le tabelle

* La relazione è 1\:N da TAEKT017 (master VIN) verso TAEKT018 (dettaglio personalizzazioni) tramite C\_VIN.


## Considerazioni Finali

* Le chiamate all'API sono sincrone (response\_type = SYNC)
* La selezione dei VIN avviene per assenza di C\_DATETIME\_REQUEST\_API e filtro per C\_MERCATO
* Dopo l’elaborazione dei nuovi VIN, vengono riprocessati i VIN con C\_RESPONSE\_CODE diverso da 200




