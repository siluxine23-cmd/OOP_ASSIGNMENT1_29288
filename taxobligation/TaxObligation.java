package com.auca.taxobligation;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public class TaxObligation implements Identifiable, Validatable {
    private String obligationId;
    private com.auca.abstracts.RegisteredTaxpayer taxpayer;
    private com.auca.taxtype.TaxType taxType;
    private java.time.LocalDate periodStart;
    private java.time.LocalDate periodEnd;
    private java.time.LocalDate dueDate;

    public TaxObligation() {
    }
    public TaxObligation(String obligationId, com.auca.abstracts.RegisteredTaxpayer taxpayer, com.auca.taxtype.TaxType taxType, java.time.LocalDate periodStart, java.time.LocalDate periodEnd, java.time.LocalDate dueDate) {
        this.obligationId = obligationId;
        this.taxpayer = taxpayer;
        this.taxType = taxType;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.dueDate = dueDate;
    }
    public String getObligationId() { return obligationId; }
    public void setObligationId(String obligationId) { this.obligationId = obligationId; }
    public com.auca.abstracts.RegisteredTaxpayer getTaxpayer() { return taxpayer; }
    public void setTaxpayer(com.auca.abstracts.RegisteredTaxpayer taxpayer) { this.taxpayer = taxpayer; }
    public com.auca.taxtype.TaxType getTaxType() { return taxType; }
    public void setTaxType(com.auca.taxtype.TaxType taxType) { this.taxType = taxType; }
    public java.time.LocalDate getPeriodStart() { return periodStart; }
    public void setPeriodStart(java.time.LocalDate periodStart) { this.periodStart = periodStart; }
    public java.time.LocalDate getPeriodEnd() { return periodEnd; }
    public void setPeriodEnd(java.time.LocalDate periodEnd) { this.periodEnd = periodEnd; }
    public java.time.LocalDate getDueDate() { return dueDate; }
    public void setDueDate(java.time.LocalDate dueDate) { this.dueDate = dueDate; }
    public String getId() { return obligationId; }
    public String getDisplayName() { return String.valueOf(obligationId); }
    public boolean isActive() { return true; }
    public void validate() throws ValidationException {
        if (obligationId == null || obligationId.trim().isEmpty()) throw new ValidationException("ID is required.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return "TaxObligation: " + getDisplayName() + " [ID=" + getId() + "]"; }
}