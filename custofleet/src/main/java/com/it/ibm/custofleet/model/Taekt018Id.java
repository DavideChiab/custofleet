package com.it.ibm.custofleet.model;

import java.io.Serializable;

public class Taekt018Id implements Serializable {
    private String cVin;
    private String cCodPersn;
    private String cCodLanguage;

    public Taekt018Id() {
    }

    public Taekt018Id(String cVin, String cCodPersn, String cCodLanguage) {
        this.cVin = cVin;
        this.cCodPersn = cCodPersn;
        this.cCodLanguage = cCodLanguage;
    }

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

    public String getCCodLanguage() {
        return this.cCodLanguage;
    }

    public void setCCodLanguage(String cCodLanguage) {
        this.cCodLanguage = cCodLanguage;
    }
}
