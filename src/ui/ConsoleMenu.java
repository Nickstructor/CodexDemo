package ui;
import model.Section;
import model.Student;
import repository.StudentRepository;
import service.*;
import util.*;
import java.util.Scanner;
public class ConsoleMenu {
    private final StudentRepository students;
    private final RegistrationService registration;
    private final ScheduleService schedules;
    private final ReportService reports;
    public ConsoleMenu(StudentRepository students, RegistrationService registration,
            ScheduleService schedules, ReportService reports) {
        this.students = students;
        this.registration = registration;
        this.schedules = schedules;
        this.reports = reports;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running && scanner.hasNextLine()) {
            System.out.println("1 Students  2 Sections  3 Register  4 Drop  5 Schedule  0 Exit");
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        for (Student student : students.findAll()) {
                            System.out.println(student.getId() + " " + student.getName());
                        }
                        break;
                    case "2":
                        for (String line : reports.sectionSummary()) { System.out.println(line); }
                        break;
                    case "3":
                    case "4":
                        System.out.println("Student ID:");
                        int id = InputValidator.positiveId(scanner.nextLine());
                        System.out.println("Section ID:");
                        String sectionId = scanner.nextLine().trim();
                        System.out.println(choice.equals("3") ? registration.register(id, sectionId)
                            : registration.drop(id, sectionId));
                        break;
                    case "5":
                        System.out.println("Student ID:");
                        int studentId = InputValidator.positiveId(scanner.nextLine());
                        if (students.findById(studentId) == null) {
                            System.out.println("Student not found");
                            break;
                        }
                        for (Section section : schedules.getSchedule(studentId)) {
                            System.out.println(section.getId() + " " + section.getMeetingTime());
                        }
                        break;
                    case "0": running = false; break;
                    default: System.out.println("Choose a menu option");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Goodbye. Restart the application to reset the sample data.");
    }
}
