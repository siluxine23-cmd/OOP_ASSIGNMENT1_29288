package com.auca.taxclearance;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public class TaxClearance implements Identifiable, Validatable {
    private String clearanceId;
    private com.auca.abstracts.RegisteredTaxpayer taxpayer;
    private java.time.LocalDate requestDate;
    private java.time.LocalDate expiryDate;
    private String status;
    private com.auca.revenueofficer.RevenueOfficer approvedBy;

    public TaxClearance() {
    }
    public TaxClearance(String clearanceId, com.auca.abstracts.RegisteredTaxpayer taxpayer, java.time.LocalDate requestDate, java.time.LocalDate expiryDate, String status, com.auca.revenueofficer.RevenueOfficer approvedBy) {
        this.clearanceId = clearanceId;
        this.taxpayer = taxpayer;
        this.requestDate = requestDate;
        this.expiryDate = expiryDate;
        this.status = status;
        this.approvedBy = approvedBy;
    }
    public String getClearanceId() { return clearanceId; }
    public void setClearanceId(String clearanceId) { this.clearanceId = clearanceId; }
    public com.auca.abstracts.RegisteredTaxpayer getTaxpayer() { return taxpayer; }
    public void setTaxpayer(com.auca.abstracts.RegisteredTaxpayer taxpayer) { this.taxpayer = taxpayer; }
    public java.time.LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(java.time.LocalDate requestDate) { this.requestDate = requestDate; }
    public java.time.LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(java.time.LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public com.auca.revenueofficer.RevenueOfficer getApprovedBy() { return approvedBy; }
    public void setApprovedBy(com.auca.revenueofficer.RevenueOfficer approvedBy) { this.approvedBy = approvedBy; }
    public String getId() { return clearanceId; }
    public String getDisplayName() { return String.valueOf(clearanceId); }
    public boolean isActive() { return true; }
    public void validate() throws ValidationException {
        if (clearanceId == null || clearanceId.trim().isEmpty()) throw new ValidationException("ID is required.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return "TaxClearance: " + getDisplayName() + " [ID=" + getId() + "]"; }
}