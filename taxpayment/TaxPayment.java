package com.auca.taxpayment;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public class TaxPayment implements Identifiable, Validatable {
    private String paymentId;
    private com.auca.taxassessment.TaxAssessment assessment;
    private String paymentReference;
    private java.math.BigDecimal amount;
    private java.time.LocalDate paymentDate;
    private String paymentMethod;

    public TaxPayment() {
    }
    public TaxPayment(String paymentId, com.auca.taxassessment.TaxAssessment assessment, String paymentReference, java.math.BigDecimal amount, java.time.LocalDate paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.assessment = assessment;
        this.paymentReference = paymentReference;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public com.auca.taxassessment.TaxAssessment getAssessment() { return assessment; }
    public void setAssessment(com.auca.taxassessment.TaxAssessment assessment) { this.assessment = assessment; }
    public String getPaymentReference() { return paymentReference; }
    public void setPaymentReference(String paymentReference) { this.paymentReference = paymentReference; }
    public java.math.BigDecimal getAmount() { return amount; }
    public void setAmount(java.math.BigDecimal amount) { this.amount = amount; }
    public java.time.LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(java.time.LocalDate paymentDate) { this.paymentDate = paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getId() { return paymentId; }
    public String getDisplayName() { return String.valueOf(paymentId); }
    public boolean isActive() { return true; }
    public void validate() throws ValidationException {
        if (paymentId == null || paymentId.trim().isEmpty()) throw new ValidationException("ID is required.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return "TaxPayment: " + getDisplayName() + " [ID=" + getId() + "]"; }
}