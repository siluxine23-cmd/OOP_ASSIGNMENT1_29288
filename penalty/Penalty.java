package com.auca.penalty;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public class Penalty implements Identifiable, Validatable {
    private String penaltyId;
    private com.auca.taxobligation.TaxObligation obligation;
    private String penaltyType;
    private java.math.BigDecimal baseAmount;
    private java.math.BigDecimal penaltyRate;
    private java.math.BigDecimal penaltyAmount;

    public Penalty() {
    }
    public Penalty(String penaltyId, com.auca.taxobligation.TaxObligation obligation, String penaltyType, java.math.BigDecimal baseAmount, java.math.BigDecimal penaltyRate, java.math.BigDecimal penaltyAmount) {
        this.penaltyId = penaltyId;
        this.obligation = obligation;
        this.penaltyType = penaltyType;
        this.baseAmount = baseAmount;
        this.penaltyRate = penaltyRate;
        this.penaltyAmount = penaltyAmount;
    }
    public String getPenaltyId() { return penaltyId; }
    public void setPenaltyId(String penaltyId) { this.penaltyId = penaltyId; }
    public com.auca.taxobligation.TaxObligation getObligation() { return obligation; }
    public void setObligation(com.auca.taxobligation.TaxObligation obligation) { this.obligation = obligation; }
    public String getPenaltyType() { return penaltyType; }
    public void setPenaltyType(String penaltyType) { this.penaltyType = penaltyType; }
    public java.math.BigDecimal getBaseAmount() { return baseAmount; }
    public void setBaseAmount(java.math.BigDecimal baseAmount) { this.baseAmount = baseAmount; }
    public java.math.BigDecimal getPenaltyRate() { return penaltyRate; }
    public void setPenaltyRate(java.math.BigDecimal penaltyRate) { this.penaltyRate = penaltyRate; }
    public java.math.BigDecimal getPenaltyAmount() { return penaltyAmount; }
    public void setPenaltyAmount(java.math.BigDecimal penaltyAmount) { this.penaltyAmount = penaltyAmount; }
    public String getId() { return penaltyId; }
    public String getDisplayName() { return String.valueOf(penaltyId); }
    public boolean isActive() { return true; }
    public void validate() throws ValidationException {
        if (penaltyId == null || penaltyId.trim().isEmpty()) throw new ValidationException("ID is required.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return "Penalty: " + getDisplayName() + " [ID=" + getId() + "]"; }
}