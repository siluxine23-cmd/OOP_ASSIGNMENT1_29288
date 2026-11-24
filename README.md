 HEAD
# Tax Administration Management System (TAMS)

Java console project for the AUCA_ID OOP practical assignment.

## Requirements
- JDK 8 or later (uses `LocalDate` and `BigDecimal`)
- Compile from the project root:

```bash
javac -d out $(find src -name "*.java")
java -cp out com.auca.main.Main
```

On Windows PowerShell:

```powershell
Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName } | Set-Content sources.txt
javac -d out @sources.txt
java -cp out com.auca.main.Main
```

## Important implementation notes
- The project contains the required 2 interfaces, 2 abstract classes, and 11 concrete domain classes.
- Each abstract/concrete domain class declares at least six private fields.
- Money uses `BigDecimal`; dates use `LocalDate`.
- The main application uses one shared `Scanner` and fixed-size arrays.
- Menu options 1–4, 9–11, and 16–21 have working baseline implementations. Options 5–8 and 12–15 display the relevant prerequisites and business rules, but still need their full record-selection/save workflows completed before final submission.
- The assignment's financial rates and rules are fictional teaching values, not official tax law.

## Suggested next development stage
Complete the linked-record workflows for obligations, declarations, assessments, payments, penalties, refunds and clearances, then add the four-step BACK/CANCEL/review forms and all acceptance-test scenarios from the assignment.

# OOP_ASSIGNMENT1_29288
Assignment
 3169b8da4c7cec94c3dae2935cd10192531371f5
