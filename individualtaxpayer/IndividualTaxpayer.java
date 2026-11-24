package com.auca.individualtaxpayer;

import com.auca.abstracts.RegisteredTaxpayer;
import com.auca.exceptions.ValidationException;

public class IndividualTaxpayer extends RegisteredTaxpayer {
    private String nationalId;
    private String occupation;
    private String businessName;
    private java.time.LocalDate businessStartDate;
    private java.math.BigDecimal annualTurnover;
    private boolean resident;

    public IndividualTaxpayer() {
        super();
    }
    public IndividualTaxpayer(String nationalId, String occupation, String businessName, java.time.LocalDate businessStartDate, java.math.BigDecimal annualTurnover, boolean resident) {
        super();
        this.nationalId = nationalId;
        this.occupation = occupation;
        this.businessName = businessName;
        this.businessStartDate = businessStartDate;
        this.annualTurnover = annualTurnover;
        this.resident = resident;
    }
    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }
    public java.time.LocalDate getBusinessStartDate() { return businessStartDate; }
    public void setBusinessStartDate(java.time.LocalDate businessStartDate) { this.businessStartDate = businessStartDate; }
    public java.math.BigDecimal getAnnualTurnover() { return annualTurnover; }
    public void setAnnualTurnover(java.math.BigDecimal annualTurnover) { this.annualTurnover = annualTurnover; }
    public boolean getResident() { return resident; }
    public void setResident(boolean resident) { this.resident = resident; }
    @Override public String getDisplayName() { return super.getDisplayName(); }
    @Override public void validate() throws ValidationException { super.validate(); }
    @Override public String getSummary() { return "IndividualTaxpayer: " + super.getSummary(); }
}