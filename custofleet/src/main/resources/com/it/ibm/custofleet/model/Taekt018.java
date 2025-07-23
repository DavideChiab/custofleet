package com.it.ibm.custofleet.model;

import javax.persistence.*;

@Entity
@IdClass(Taekt018Id.class)
@Table(name = "TAEKT018")
public class Taekt018 {
    @Id
    @Column(name = "C_VIN", columnDefinition = "CHAR")
    private String cVin;

    @Id
    @Column(name = "C_COD_PERSN", columnDefinition = "CHAR")
    private String cCodPersn;

    @Column(name = "C_DESC_PERSN", columnDefinition = "CHAR")
    private String cDescPersn;

    @Id
    @Column(name = "C_COD_LANGUAGE", columnDefinition = "CHAR")
    private String cCodLanguage;

    @Column(name = "C_VALUE_PERSN_PLANT")
    private Long cValuePersnPlant;

    @Column(name = "C_VALUE_PERSN_IC")
    private Long cValuePersnIc;

    @Column(name = "C_VALUE_PERSN_SALE")
    private Long cValuePersnSale;

    @Column(name = "C_CURRENCY", columnDefinition = "CHAR")
    private String cCurrency;

    @Column(name = "C_DATETIME_INS_UPD", columnDefinition = "CHAR")
    private String cDatetimeInsUpd;

    @Column(name = "C_CALL_ID")
    private String cCallId;

    public String getCVin() {
        return this.cVin;
    }

    public void setCVin(String cVin) {
        this.cVin = cVin;
    }

    public String getCCodPersn() {
        return this.cCodPersn;
    }

    public void setCCodPersn(String cCodPersn) {
        this.cCodPersn = cCodPersn;
    }

    public String getCDescPersn() {
        return this.cDescPersn;
    }

    public void setCDescPersn(String cDescPersn) {
        this.cDescPersn = cDescPersn;
    }

    public String getCCodLanguage() {
        return this.cCodLanguage;
    }

    public void setCCodLanguage(String cCodLanguage) {
        this.cCodLanguage = cCodLanguage;
    }

    public Long getCValuePersnPlant() {
        return this.cValuePersnPlant;
    }

    public void setCValuePersnPlant(Long cValuePersnPlant) {
        this.cValuePersnPlant = cValuePersnPlant;
    }

    public Long getCValuePersnIc() {
        return this.cValuePersnIc;
    }

    public void setCValuePersnIc(Long cValuePersnIc) {
        this.cValuePersnIc = cValuePersnIc;
    }

    public Long getCValuePersnSale() {
        return this.cValuePersnSale;
    }

    public void setCValuePersnSale(Long cValuePersnSale) {
        this.cValuePersnSale = cValuePersnSale;
    }

    public String getCCurrency() {
        return this.cCurrency;
    }

    public void setCCurrency(String cCurrency) {
        this.cCurrency = cCurrency;
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
}
