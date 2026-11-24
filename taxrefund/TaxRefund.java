package com.auca.taxrefund;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public class TaxRefund implements Identifiable, Validatable {
    private String refundId;
    private com.auca.abstracts.RegisteredTaxpayer taxpayer;
    private com.auca.taxassessment.TaxAssessment assessment;
    private java.math.BigDecimal requestedAmount;
    private java.time.LocalDate requestDate;
    private String status;

    public TaxRefund() {
    }
    public TaxRefund(String refundId, com.auca.abstracts.RegisteredTaxpayer taxpayer, com.auca.taxassessment.TaxAssessment assessment, java.math.BigDecimal requestedAmount, java.time.LocalDate requestDate, String status) {
        this.refundId = refundId;
        this.taxpayer = taxpayer;
        this.assessment = assessment;
        this.requestedAmount = requestedAmount;
        this.requestDate = requestDate;
        this.status = status;
    }
    public String getRefundId() { return refundId; }
    public void setRefundId(String refundId) { this.refundId = refundId; }
    public com.auca.abstracts.RegisteredTaxpayer getTaxpayer() { return taxpayer; }
    public void setTaxpayer(com.auca.abstracts.RegisteredTaxpayer taxpayer) { this.taxpayer = taxpayer; }
    public com.auca.taxassessment.TaxAssessment getAssessment() { return assessment; }
    public void setAssessment(com.auca.taxassessment.TaxAssessment assessment) { this.assessment = assessment; }
    public java.math.BigDecimal getRequestedAmount() { return requestedAmount; }
    public void setRequestedAmount(java.math.BigDecimal requestedAmount) { this.requestedAmount = requestedAmount; }
    public java.time.LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(java.time.LocalDate requestDate) { this.requestDate = requestDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getId() { return refundId; }
    public String getDisplayName() { return String.valueOf(refundId); }
    public boolean isActive() { return true; }
    public void validate() throws ValidationException {
        if (refundId == null || refundId.trim().isEmpty()) throw new ValidationException("ID is required.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return "TaxRefund: " + getDisplayName() + " [ID=" + getId() + "]"; }
}