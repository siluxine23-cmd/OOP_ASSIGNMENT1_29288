package com.auca.taxtype;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public class TaxType implements Identifiable, Validatable {
    private String taxTypeId;
    private String taxCode;
    private String taxName;
    private java.math.BigDecimal rate;
    private String filingFrequency;
    private boolean active;

    public TaxType() {
    }
    public TaxType(String taxTypeId, String taxCode, String taxName, java.math.BigDecimal rate, String filingFrequency, boolean active) {
        this.taxTypeId = taxTypeId;
        this.taxCode = taxCode;
        this.taxName = taxName;
        this.rate = rate;
        this.filingFrequency = filingFrequency;
        this.active = active;
    }
    public String getTaxTypeId() { return taxTypeId; }
    public void setTaxTypeId(String taxTypeId) { this.taxTypeId = taxTypeId; }
    public String getTaxCode() { return taxCode; }
    public void setTaxCode(String taxCode) { this.taxCode = taxCode; }
    public String getTaxName() { return taxName; }
    public void setTaxName(String taxName) { this.taxName = taxName; }
    public java.math.BigDecimal getRate() { return rate; }
    public void setRate(java.math.BigDecimal rate) { this.rate = rate; }
    public String getFilingFrequency() { return filingFrequency; }
    public void setFilingFrequency(String filingFrequency) { this.filingFrequency = filingFrequency; }
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public String getId() { return taxTypeId; }
    public String getDisplayName() { return String.valueOf(taxName); }
    public boolean isActive() { return active; }
    public void validate() throws ValidationException {
        if (taxTypeId == null || taxTypeId.trim().isEmpty()) throw new ValidationException("ID is required.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return "TaxType: " + getDisplayName() + " [ID=" + getId() + "]"; }
}