package com.auca.abstracts;

import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;

public abstract class TaxParty implements Identifiable, Validatable {
    private String partyId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private java.time.LocalDate dateOfBirth;

    public TaxParty() {
    }
    public TaxParty(String partyId, String firstName, String lastName, String email, String phoneNumber, java.time.LocalDate dateOfBirth) {
        this.partyId = partyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }
    public String getPartyId() { return partyId; }
    public void setPartyId(String partyId) { this.partyId = partyId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public java.time.LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(java.time.LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getId() { return partyId; }
    public String getDisplayName() { return ((firstName == null ? "" : firstName) + " " + (lastName == null ? "" : lastName)).trim(); }
    public boolean isActive() { return true; }
    public void validate() throws ValidationException {
        if (partyId == null || partyId.trim().isEmpty()) throw new ValidationException("Party ID is required.");
        if (firstName == null || firstName.trim().length() < 2) throw new ValidationException("First name must contain at least 2 characters.");
        if (lastName == null || lastName.trim().length() < 2) throw new ValidationException("Last name must contain at least 2 characters.");
    }
    public void printDetails() { System.out.println(getSummary()); }
    public String getSummary() { return getId() + " - " + getDisplayName(); }
}