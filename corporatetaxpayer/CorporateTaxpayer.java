package com.auca.corporatetaxpayer;

import com.auca.abstracts.RegisteredTaxpayer;
import com.auca.exceptions.ValidationException;

public class CorporateTaxpayer extends RegisteredTaxpayer {
    private String companyRegistrationNo;
    private String legalName;
    private java.time.LocalDate incorporationDate;
    private String businessSector;
    private String authorizedRepresentative;
    private java.math.BigDecimal annualTurnover;

    public CorporateTaxpayer() {
        super();
    }
    public CorporateTaxpayer(String companyRegistrationNo, String legalName, java.time.LocalDate incorporationDate, String businessSector, String authorizedRepresentative, java.math.BigDecimal annualTurnover) {
        super();
        this.companyRegistrationNo = companyRegistrationNo;
        this.legalName = legalName;
        this.incorporationDate = incorporationDate;
        this.businessSector = businessSector;
        this.authorizedRepresentative = authorizedRepresentative;
        this.annualTurnover = annualTurnover;
    }
    public String getCompanyRegistrationNo() { return companyRegistrationNo; }
    public void setCompanyRegistrationNo(String companyRegistrationNo) { this.companyRegistrationNo = companyRegistrationNo; }
    public String getLegalName() { return legalName; }
    public void setLegalName(String legalName) { this.legalName = legalName; }
    public java.time.LocalDate getIncorporationDate() { return incorporationDate; }
    public void setIncorporationDate(java.time.LocalDate incorporationDate) { this.incorporationDate = incorporationDate; }
    public String getBusinessSector() { return businessSector; }
    public void setBusinessSector(String businessSector) { this.businessSector = businessSector; }
    public String getAuthorizedRepresentative() { return authorizedRepresentative; }
    public void setAuthorizedRepresentative(String authorizedRepresentative) { this.authorizedRepresentative = authorizedRepresentative; }
    public java.math.BigDecimal getAnnualTurnover() { return annualTurnover; }
    public void setAnnualTurnover(java.math.BigDecimal annualTurnover) { this.annualTurnover = annualTurnover; }
    @Override public String getDisplayName() { return super.getDisplayName(); }
    @Override public void validate() throws ValidationException { super.validate(); }
    @Override public String getSummary() { return "CorporateTaxpayer: " + super.getSummary(); }
}