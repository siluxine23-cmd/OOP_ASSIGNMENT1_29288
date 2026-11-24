package com.auca.taxassessment;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public class TaxAssessment implements Identifiable, Validatable {
    private String assessmentId;
    private com.auca.taxdeclaration.TaxDeclaration declaration;
    private java.math.BigDecimal assessedTax;
    private java.math.BigDecimal adjustmentAmount;
    private java.time.LocalDate assessmentDate;
    private String status;

    public TaxAssessment() {
    }
    public TaxAssessment(String assessmentId, com.auca.taxdeclaration.TaxDeclaration declaration, java.math.BigDecimal assessedTax, java.math.BigDecimal adjustmentAmount, java.time.LocalDate assessmentDate, String status) {
        this.assessmentId = assessmentId;
        this.declaration = declaration;
        this.assessedTax = assessedTax;
        this.adjustmentAmount = adjustmentAmount;
        this.assessmentDate = assessmentDate;
        this.status = status;
    }
    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }
    public com.auca.taxdeclaration.TaxDeclaration getDeclaration() { return declaration; }
    public void setDeclaration(com.auca.taxdeclaration.TaxDeclaration declaration) { this.declaration = declaration; }
    public java.math.BigDecimal getAssessedTax() { return assessedTax; }
    public void setAssessedTax(java.math.BigDecimal assessedTax) { this.assessedTax = assessedTax; }
    public java.math.BigDecimal getAdjustmentAmount() { return adjustmentAmount; }
    public void setAdjustmentAmount(java.math.BigDecimal adjustmentAmount) { this.adjustmentAmount = adjustmentAmount; }
    public java.time.LocalDate getAssessmentDate() { return assessmentDate; }
    public void setAssessmentDate(java.time.LocalDate assessmentDate) { this.assessmentDate = assessmentDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getId() { return assessmentId; }
    public String getDisplayName() { return String.valueOf(assessmentId); }
    public boolean isActive() { return true; }
    public void validate() throws ValidationException {
        if (assessmentId == null || assessmentId.trim().isEmpty()) throw new ValidationException("ID is required.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return "TaxAssessment: " + getDisplayName() + " [ID=" + getId() + "]"; }
}