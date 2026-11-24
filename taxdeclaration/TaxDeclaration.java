package com.auca.taxdeclaration;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public class TaxDeclaration implements Identifiable, Validatable {
    private String declarationId;
    private com.auca.taxobligation.TaxObligation obligation;
    private java.time.LocalDate filingDate;
    private java.math.BigDecimal taxableAmount;
    private java.math.BigDecimal declaredTax;
    private String status;

    public TaxDeclaration() {
    }
    public TaxDeclaration(String declarationId, com.auca.taxobligation.TaxObligation obligation, java.time.LocalDate filingDate, java.math.BigDecimal taxableAmount, java.math.BigDecimal declaredTax, String status) {
        this.declarationId = declarationId;
        this.obligation = obligation;
        this.filingDate = filingDate;
        this.taxableAmount = taxableAmount;
        this.declaredTax = declaredTax;
        this.status = status;
    }
    public String getDeclarationId() { return declarationId; }
    public void setDeclarationId(String declarationId) { this.declarationId = declarationId; }
    public com.auca.taxobligation.TaxObligation getObligation() { return obligation; }
    public void setObligation(com.auca.taxobligation.TaxObligation obligation) { this.obligation = obligation; }
    public java.time.LocalDate getFilingDate() { return filingDate; }
    public void setFilingDate(java.time.LocalDate filingDate) { this.filingDate = filingDate; }
    public java.math.BigDecimal getTaxableAmount() { return taxableAmount; }
    public void setTaxableAmount(java.math.BigDecimal taxableAmount) { this.taxableAmount = taxableAmount; }
    public java.math.BigDecimal getDeclaredTax() { return declaredTax; }
    public void setDeclaredTax(java.math.BigDecimal declaredTax) { this.declaredTax = declaredTax; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getId() { return declarationId; }
    public String getDisplayName() { return String.valueOf(declarationId); }
    public boolean isActive() { return true; }
    public void validate() throws ValidationException {
        if (declarationId == null || declarationId.trim().isEmpty()) throw new ValidationException("ID is required.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return "TaxDeclaration: " + getDisplayName() + " [ID=" + getId() + "]"; }
}