package com.auca.revenueofficer;

import com.auca.abstracts.TaxParty;
import com.auca.exceptions.ValidationException;

public class RevenueOfficer extends TaxParty {
    private String staffNumber;
    private String department;
    private String role;
    private java.time.LocalDate hireDate;
    private java.math.BigDecimal approvalLimit;
    private boolean active;

    public RevenueOfficer() {
        super();
    }
    public RevenueOfficer(String staffNumber, String department, String role, java.time.LocalDate hireDate, java.math.BigDecimal approvalLimit, boolean active) {
        super();
        this.staffNumber = staffNumber;
        this.department = department;
        this.role = role;
        this.hireDate = hireDate;
        this.approvalLimit = approvalLimit;
        this.active = active;
    }
    public String getStaffNumber() { return staffNumber; }
    public void setStaffNumber(String staffNumber) { this.staffNumber = staffNumber; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public java.time.LocalDate getHireDate() { return hireDate; }
    public void setHireDate(java.time.LocalDate hireDate) { this.hireDate = hireDate; }
    public java.math.BigDecimal getApprovalLimit() { return approvalLimit; }
    public void setApprovalLimit(java.math.BigDecimal approvalLimit) { this.approvalLimit = approvalLimit; }
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    @Override public String getDisplayName() { return super.getDisplayName(); }
    @Override public void validate() throws ValidationException { super.validate(); }
    @Override public String getSummary() { return "RevenueOfficer: " + super.getSummary(); }
}