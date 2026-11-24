package com.auca.abstracts;

import com.auca.exceptions.ValidationException;

public abstract class RegisteredTaxpayer extends TaxParty {
    private String tin;
    private java.time.LocalDate registrationDate;
    private String taxpayerStatus;
    private String district;
    private String sector;
    private String taxOffice;

    public RegisteredTaxpayer() {
        super();
    }
    public RegisteredTaxpayer(String tin, java.time.LocalDate registrationDate, String taxpayerStatus, String district, String sector, String taxOffice) {
        super();
        this.tin = tin;
        this.registrationDate = registrationDate;
        this.taxpayerStatus = taxpayerStatus;
        this.district = district;
        this.sector = sector;
        this.taxOffice = taxOffice;
    }
    public String getTin() { return tin; }
    public void setTin(String tin) { this.tin = tin; }
    public java.time.LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(java.time.LocalDate registrationDate) { this.registrationDate = registrationDate; }
    public String getTaxpayerStatus() { return taxpayerStatus; }
    public void setTaxpayerStatus(String taxpayerStatus) { this.taxpayerStatus = taxpayerStatus; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }
    public String getTaxOffice() { return taxOffice; }
    public void setTaxOffice(String taxOffice) { this.taxOffice = taxOffice; }
    @Override public String getId() { return getTin(); }
    @Override public boolean isActive() { return "ACTIVE".equalsIgnoreCase(taxpayerStatus); }
    @Override public void validate() throws ValidationException { super.validate(); if (tin == null || !tin.matches("\\d{9}")) throw new ValidationException("TIN must contain exactly 9 digits."); }
    @Override public String getSummary() { return getDisplayName() + " | TIN: " + tin + " | " + taxpayerStatus; }
}