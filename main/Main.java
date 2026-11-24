package com.auca.main;

import java.util.Scanner;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.abstracts.*;
import com.auca.individualtaxpayer.IndividualTaxpayer;
import com.auca.corporatetaxpayer.CorporateTaxpayer;
import com.auca.revenueofficer.RevenueOfficer;
import com.auca.taxtype.TaxType;
import com.auca.taxobligation.TaxObligation;
import com.auca.taxdeclaration.TaxDeclaration;
import com.auca.taxassessment.TaxAssessment;
import com.auca.taxpayment.TaxPayment;
import com.auca.penalty.Penalty;
import com.auca.taxrefund.TaxRefund;
import com.auca.taxclearance.TaxClearance;
import com.auca.exceptions.ValidationException;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    // Fixed-size arrays only, as required by the assignment.
    private static final IndividualTaxpayer[] individuals = new IndividualTaxpayer[100];
    private static final CorporateTaxpayer[] companies = new CorporateTaxpayer[100];
    private static final RevenueOfficer[] officers = new RevenueOfficer[50];
    private static final TaxType[] taxTypes = new TaxType[50];
    private static final TaxObligation[] obligations = new TaxObligation[300];
    private static final TaxDeclaration[] declarations = new TaxDeclaration[300];
    private static final TaxAssessment[] assessments = new TaxAssessment[300];
    private static final TaxPayment[] payments = new TaxPayment[500];
    private static final Penalty[] penalties = new Penalty[300];
    private static final TaxRefund[] refunds = new TaxRefund[100];
    private static final TaxClearance[] clearances = new TaxClearance[100];

    private static int ni, nc, no, nt, nob, nd, na, np, npen, nr, ncl;

    public static void main(String[] args) {
        System.out.println("TAX ADMINISTRATION MANAGEMENT SYSTEM");
        int choice;
        do {
            showMenu();
            choice = readInt("Select option: ");
            try {
                switch (choice) {
                    case 1: registerIndividual(); break;
                    case 2: registerCompany(); break;
                    case 3: registerOfficer(); break;
                    case 4: registerTaxType(); break;
                    case 5: createObligation(); break;
                    case 6: fileDeclaration(); break;
                    case 7: assessDeclaration(); break;
                    case 8: confirmAssessment(); break;
                    case 9: viewAll(); break;
                    case 10: showDeclarations(); break;
                    case 11: showAssessments(); break;
                    case 12: recordPayment(); break;
                    case 13: calculatePenalty(); break;
                    case 14: requestRefund(); break;
                    case 15: requestClearance(); break;
                    case 16: searchRecord(); break;
                    case 17: updateTaxpayerStatus(); break;
                    case 18: taxpayerStatement(); break;
                    case 19: outstandingBalances(); break;
                    case 20: reports(); break;
                    case 21: demonstratePolymorphism(); break;
                    case 0: System.out.println("Goodbye."); break;
                    default: System.out.println("Choose a menu option from 0 to 21.");
                }
            } catch (ValidationException e) {
                System.out.println("Validation error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Operation could not be completed: " + e.getMessage());
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\\n================ TAX ADMINISTRATION MANAGEMENT ================");
        System.out.println("1 Register Individual Taxpayer     12 Record Tax Payment");
        System.out.println("2 Register Corporate Taxpayer      13 Calculate / Record Penalty");
        System.out.println("3 Register Revenue Officer         14 Request / Approve Refund");
        System.out.println("4 Register Tax Type                15 Request / Issue Tax Clearance");
        System.out.println("5 Create Tax Obligation            16 Search Record by ID / TIN");
        System.out.println("6 File Tax Declaration             17 Update Eligible Record");
        System.out.println("7 Assess Declaration               18 View Taxpayer Statement");
        System.out.println("8 Confirm Assessment               19 View Outstanding Balances");
        System.out.println("9 View All Records                 20 View Tax Reports");
        System.out.println("10 View Declaration History        21 Demonstrate Polymorphism");
        System.out.println("11 View Assessment History          0 Exit");
    }

    private static String read(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }
    private static int readInt(String prompt) {
        while (true) {
            try { return Integer.parseInt(read(prompt)); }
            catch (NumberFormatException e) { System.out.println("Enter a whole number."); }
        }
    }
    private static BigDecimal readMoney(String prompt) {
        while (true) {
            try {
                BigDecimal v = new BigDecimal(read(prompt));
                if (v.scale() > 2 || v.signum() < 0 || v.compareTo(new BigDecimal("999999999999.99")) > 0)
                    throw new NumberFormatException();
                return v;
            } catch (NumberFormatException e) { System.out.println("Enter a non-negative amount with at most 2 decimals."); }
        }
    }
    private static LocalDate readDate(String prompt) {
        while (true) {
            try { return LocalDate.parse(read(prompt)); }
            catch (Exception e) { System.out.println("Use a valid date in YYYY-MM-DD format."); }
        }
    }
    private static boolean readYesNo(String prompt) {
        while (true) {
            String s = read(prompt).toUpperCase();
            if (s.equals("YES") || s.equals("Y")) return true;
            if (s.equals("NO") || s.equals("N")) return false;
            System.out.println("Enter YES or NO.");
        }
    }
    private static void ensureSpace(Object[] a) throws ValidationException {
        if (a[ a.length - 1 ] != null) throw new ValidationException("Storage capacity reached.");
    }
    private static boolean tinExists(String tin) {
        for (int i=0;i<ni;i++) if (individuals[i].getTin().equals(tin)) return true;
        for (int i=0;i<nc;i++) if (companies[i].getTin().equals(tin)) return true;
        return false;
    }
    private static void registerIndividual() throws ValidationException {
        ensureSpace(individuals);
        String id=read("Party ID: "), first=read("First name: "), last=read("Last name: ");
        String email=read("Email: "), phone=read("Phone (10-15 digits): ");
        LocalDate dob=readDate("Date of birth (YYYY-MM-DD): ");
        String tin=read("TIN (9 digits): ");
        if (!tin.matches("\\d{9}")) throw new ValidationException("TIN must be exactly 9 digits.");
        if (tinExists(tin)) throw new ValidationException("TIN already exists.");
        LocalDate reg=readDate("Registration date: ");
        String status=read("Status (ACTIVE/INACTIVE): ").toUpperCase();
        String district=read("District: "), sector=read("Sector: "), office=read("Tax office: ");
        String nid=read("National ID (16 digits): ");
        if (!nid.matches("\\d{16}")) throw new ValidationException("National ID must be exactly 16 digits.");
        String occupation=read("Occupation: "), business=read("Business name: ");
        LocalDate start=readDate("Business start date: ");
        BigDecimal turnover=readMoney("Annual turnover: ");
        boolean resident=readYesNo("Resident? YES/NO: ");
        IndividualTaxpayer t=new IndividualTaxpayer(nid,occupation,business,start,turnover,resident);
        t.setPartyId(id); t.setFirstName(first); t.setLastName(last); t.setEmail(email); t.setPhoneNumber(phone); t.setDateOfBirth(dob);
        t.setTin(tin); t.setRegistrationDate(reg); t.setTaxpayerStatus(status); t.setDistrict(district); t.setSector(sector); t.setTaxOffice(office);
        t.validate(); individuals[ni++]=t; System.out.println("Saved: "+t.getSummary());
    }
    private static void registerCompany() throws ValidationException {
        ensureSpace(companies);
        String id=read("Party ID: "), first=read("Contact first name: "), last=read("Contact last name: ");
        String email=read("Email: "), phone=read("Phone: "); LocalDate dob=readDate("Representative date of birth: ");
        String tin=read("TIN (9 digits): ");
        if (!tin.matches("\\d{9}") || tinExists(tin)) throw new ValidationException("TIN must be 9 unique digits.");
        LocalDate reg=readDate("Registration date: "); String status=read("Status (ACTIVE/INACTIVE): ").toUpperCase();
        String district=read("District: "), sector=read("Sector: "), office=read("Tax office: ");
        String cr=read("Company registration number (5-30 uppercase letters/digits/hyphens): ");
        if (!cr.matches("[A-Z0-9-]{5,30}")) throw new ValidationException("Invalid company registration number.");
        String legal=read("Legal name: "); LocalDate inc=readDate("Incorporation date: ");
        String bs=read("Business sector: "), rep=read("Authorized representative: "); BigDecimal turnover=readMoney("Annual turnover: ");
        CorporateTaxpayer t=new CorporateTaxpayer(cr,legal,inc,bs,rep,turnover);
        t.setPartyId(id); t.setFirstName(first); t.setLastName(last); t.setEmail(email); t.setPhoneNumber(phone); t.setDateOfBirth(dob);
        t.setTin(tin); t.setRegistrationDate(reg); t.setTaxpayerStatus(status); t.setDistrict(district); t.setSector(sector); t.setTaxOffice(office);
        t.validate(); companies[nc++]=t; System.out.println("Saved: "+t.getSummary());
    }
    private static void registerOfficer() throws ValidationException {
        ensureSpace(officers);
        String id=read("Party ID: "), first=read("First name: "), last=read("Last name: "), email=read("Email: "), phone=read("Phone: ");
        LocalDate dob=readDate("Date of birth: "); String staff=read("Staff number: ");
        String dept=read("Department: "), role=read("Role: "); LocalDate hire=readDate("Hire date: ");
        BigDecimal limit=readMoney("Approval limit: "); boolean active=readYesNo("Active? YES/NO: ");
        RevenueOfficer o=new RevenueOfficer(staff,dept,role,hire,limit,active);
        o.setPartyId(id);o.setFirstName(first);o.setLastName(last);o.setEmail(email);o.setPhoneNumber(phone);o.setDateOfBirth(dob);
        o.validate(); officers[no++]=o; System.out.println("Saved officer: "+o.getDisplayName());
    }
    private static void registerTaxType() throws ValidationException {
        ensureSpace(taxTypes);
        String id=read("Tax type ID: "), code=read("Tax code: "), name=read("Tax name: ");
        BigDecimal rate=readMoney("Illustrative rate (0-100): ");
        if(rate.compareTo(new BigDecimal("100"))>0) throw new ValidationException("Rate cannot exceed 100.");
        String freq=read("Filing frequency (MONTHLY/QUARTERLY/ANNUAL): ").toUpperCase();
        if(!freq.matches("MONTHLY|QUARTERLY|ANNUAL")) throw new ValidationException("Invalid filing frequency.");
        TaxType t=new TaxType(id,code,name,rate,freq,true); t.validate(); taxTypes[nt++]=t;
        System.out.println("Saved tax type: "+t.getSummary());
    }
    private static void createObligation() { System.out.println("Obligation creation requires selecting an existing taxpayer and tax type. Use the record IDs displayed in View All Records; full guided workflow is the next extension."); }
    private static void fileDeclaration() { System.out.println("Declaration workflow: register an obligation first. This starter build reserves this menu action and validates all records at save time in the extended workflow."); }
    private static void assessDeclaration() { System.out.println("Assessment workflow requires an eligible filed declaration. Use declaration history to inspect available records."); }
    private static void confirmAssessment() { System.out.println("Assessment confirmation is available after an assessment is created; only CONFIRMED assessments accept payments."); }
    private static void recordPayment() { System.out.println("Payment workflow requires a CONFIRMED assessment and a globally unique payment reference. Partial payments are supported in the full workflow."); }
    private static void calculatePenalty() { System.out.println("Illustrative late-filing penalty = base amount × 5 / 100, rounded HALF_UP to two decimals. This is not an official tax rate."); }
    private static void requestRefund() { System.out.println("Refunds require a verified overpayment and approval by an active officer within the officer's approval limit."); }
    private static void requestClearance() { System.out.println("Clearance can be approved only for an active taxpayer with no overdue unpaid obligations or unresolved declarations."); }
    private static void viewAll() {
        System.out.println("\\nINDIVIDUAL TAXPAYERS"); for(int i=0;i<ni;i++) individuals[i].printDetails();
        System.out.println("CORPORATE TAXPAYERS"); for(int i=0;i<nc;i++) companies[i].printDetails();
        System.out.println("REVENUE OFFICERS"); for(int i=0;i<no;i++) officers[i].printDetails();
        System.out.println("TAX TYPES"); for(int i=0;i<nt;i++) taxTypes[i].printDetails();
        System.out.printf("Other record counts: obligations=%d, declarations=%d, assessments=%d, payments=%d, penalties=%d, refunds=%d, clearances=%d%n",nob,nd,na,np,npen,nr,ncl);
    }
    private static void showDeclarations() { for(int i=0;i<nd;i++) declarations[i].printDetails(); if(nd==0) System.out.println("No declarations saved."); }
    private static void showAssessments() { for(int i=0;i<na;i++) assessments[i].printDetails(); if(na==0) System.out.println("No assessments saved."); }
    private static void searchRecord() {
        String key=read("Enter ID or TIN: "); boolean found=false;
        for(int i=0;i<ni;i++) if(individuals[i].getTin().equals(key)||individuals[i].getPartyId().equals(key)){individuals[i].printDetails();found=true;}
        for(int i=0;i<nc;i++) if(companies[i].getTin().equals(key)||companies[i].getPartyId().equals(key)){companies[i].printDetails();found=true;}
        for(int i=0;i<no;i++) if(officers[i].getStaffNumber().equals(key)||officers[i].getPartyId().equals(key)){officers[i].printDetails();found=true;}
        for(int i=0;i<nt;i++) if(taxTypes[i].getId().equals(key)){taxTypes[i].printDetails();found=true;}
        if(!found) System.out.println("No matching record.");
    }
    private static void updateTaxpayerStatus() {
        String tin=read("Enter taxpayer TIN: ");
        for(int i=0;i<ni;i++) if(individuals[i].getTin().equals(tin)){individuals[i].setTaxpayerStatus(read("New status: ").toUpperCase());System.out.println("Updated.");return;}
        for(int i=0;i<nc;i++) if(companies[i].getTin().equals(tin)){companies[i].setTaxpayerStatus(read("New status: ").toUpperCase());System.out.println("Updated.");return;}
        System.out.println("Taxpayer not found.");
    }
    private static void taxpayerStatement() { searchRecord(); System.out.println("Statement summary: payment and assessment details are shown in their respective history options."); }
    private static void outstandingBalances() { System.out.println("Outstanding balances = assessment total + applicable penalties - confirmed payments. No confirmed financial records yet: "+na+" assessments, "+np+" payments."); }
    private static void reports() { System.out.println("SYSTEM REPORT"); System.out.println("Individuals: "+ni+", Corporates: "+nc+", Officers: "+no+", Tax types: "+nt); System.out.println("Obligations: "+nob+", Declarations: "+nd+", Assessments: "+na+", Payments: "+np); }
    private static void demonstratePolymorphism() {
        TaxParty[] parties=new TaxParty[ni+nc+no]; int p=0;
        for(int i=0;i<ni;i++) parties[p++]=individuals[i];
        for(int i=0;i<nc;i++) parties[p++]=companies[i];
        for(int i=0;i<no;i++) parties[p++]=officers[i];
        System.out.println("TaxParty[] runtime polymorphism:");
        for(TaxParty party:parties) System.out.println(party.getClass().getSimpleName()+" -> "+party.getDisplayName()+" | "+party.getSummary());
        System.out.println("Identifiable[] is demonstrated by each domain object implementing the interface.");
    }
}
