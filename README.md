# Course Registration Workshop with Collections
A Java console application for practicing repository exploration, planning, debugging, verification and review with Codex. All data is fictional and initialized directly as objects.

## Requirements
JDK 17 or newer. For the workshop use VS Code with the official Codex extension and working account access. The application uses only the standard JDK.

## Run from this folder
```text
java -version
javac -version
javac -d out @sources.txt
java -cp out AllTests
java -cp out Main
```
Expected test result: PASS: 25 checks. New Java files must be listed in sources.txt and new test suites called from AllTests. Explicit assertions do not require -ea.

## Menu
1 Students, 2 Sections, 3 Register, 4 Drop, 5 Schedule, 0 Exit. Repositories use ArrayList collections. Changes exist for the current run only. Restart Main to reset the sample data.

## Sample records
SampleData.populate creates students, courses, sections and enrollments at startup. Alex 1001 begins in JAVA-A Monday 09:00-10:00. NET-A Monday 09:30-10:30 overlaps it. DB-A Monday 10:00-11:00 is adjacent. Sam 1002 occupies WEB-A Tuesday 09:00-10:00, capacity one. Jordan 1003 has no enrollment. Student IDs are numeric and section IDs are case-sensitive.

## Architecture
Main creates repositories, calls SampleData and wires services. ConsoleMenu handles input. RegistrationService handles enrollment changes. ScheduleService resolves enrolled sections. ReportService formats section summaries. Repositories own their collections and return copies of lists. Instructor is reserved for an optional extension.

## Workshop scope
Schedule conflict and section capacity checks are absent. Duplicate registration and invalid IDs already have protection. Meetings use one day and interval with an exclusive end. Overnight meetings, concurrent registration and authentication are outside scope.

## Recovery and learning evidence
Restart Main to reset data. Extract a fresh project copy to reset code. Keep work you want before resetting. Optionally create a Git baseline and inspect changes with git diff. Record the task, plan, changed files, actual test output and a decision you challenged. Follow your course AI policy.
