package com.it.ibm.custofleet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAEKT017")
public class Taekt017 {
    @Id
    @Column(name = "C_VIN", columnDefinition = "CHAR")
    private String cVin;

    @Column(name = "C_FL_STATUS_PERSN", columnDefinition = "CHAR")
    private String cFlStatusPersn;

    @Column(name = "C_DATE_END_PERSN", columnDefinition = "CHAR")
    private String cDateEndPersn;

    @Column(name = "C_DATE_CANC_PERSN", columnDefinition = "CHAR")
    private String cDateCancPersn;

    @Column(name = "C_DATETIME_INS_UPD", columnDefinition = "CHAR")
    private String cDatetimeInsUpd;

    @Column(name = "C_CALL_ID")
    private String cCallId;

    @Column(name = "C_DATETIME_REQUEST_API", columnDefinition = "CHAR")
    private String cDatetimeRequestApi;

    @Column(name = "C_ESITO_API")
    private String cEsitoApi;

    @Column(name = "C_MERCATO", columnDefinition = "CHAR")
    private String cMercato;

    @Column(name = "C_RETURN_CODE", columnDefinition = "CHAR")
    private String cReturnCode;

    @Column(name = "C_RESPONSE_CODE", columnDefinition = "CHAR")
    private String cResponseCode;

    public String getCVin() {
        return this.cVin;
    }

    public void setCVin(String cVin) {
        this.cVin = cVin;
    }

    public String getCFlStatusPersn() {
        return this.cFlStatusPersn;
    }

    public void setCFlStatusPersn(String cFlStatusPersn) {
        this.cFlStatusPersn = cFlStatusPersn;
    }

    public String getCDateEndPersn() {
        return this.cDateEndPersn;
    }

    public void setCDateEndPersn(String cDateEndPersn) {
        this.cDateEndPersn = cDateEndPersn;
    }

    public String getCDateCancPersn() {
        return this.cDateCancPersn;
    }

    public void setCDateCancPersn(String cDateCancPersn) {
        this.cDateCancPersn = cDateCancPersn;
    }

    public String getCDatetimeInsUpd() {
        return this.cDatetimeInsUpd;
    }

    public void setCDatetimeInsUpd(String cDatetimeInsUpd) {
        this.cDatetimeInsUpd = cDatetimeInsUpd;
    }

    public String getCCallId() {
        return this.cCallId;
    }

    public void setCCallId(String cCallId) {
        this.cCallId = cCallId;
    }

    public String getCDatetimeRequestApi() {
        return this.cDatetimeRequestApi;
    }

    public void setCDatetimeRequestApi(String cDatetimeRequestApi) {
        this.cDatetimeRequestApi = cDatetimeRequestApi;
    }

    public String getCEsitoApi() {
        return this.cEsitoApi;
    }

    public void setCEsitoApi(String cEsitoApi) {
        this.cEsitoApi = cEsitoApi;
    }

    public String getCMercato() {
        return this.cMercato;
    }

    public void setCMercato(String cMercato) {
        this.cMercato = cMercato;
    }

    public String getCReturnCode() {
        return this.cReturnCode;
    }

    public void setCReturnCode(String cReturnCode) {
        this.cReturnCode = cReturnCode;
    }

    public String getCResponseCode() {
        return this.cResponseCode;
    }

    public void setCResponseCode(String cResponseCode) {
        this.cResponseCode = cResponseCode;
    }
}
