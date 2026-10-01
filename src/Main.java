import repository.*;
import service.*;
import ui.ConsoleMenu;
import util.SampleData;

public class Main {
    public static void main(String[] args) {
        StudentRepository students = new StudentRepository();
        CourseRepository courses = new CourseRepository();
        SectionRepository sections = new SectionRepository();
        EnrollmentRepository enrollments = new EnrollmentRepository();
        SampleData.populate(students, courses, sections, enrollments);
        ScheduleService schedules = new ScheduleService(enrollments, sections);
        RegistrationService registration = new RegistrationService(students, sections, enrollments, schedules);
        ReportService reports = new ReportService(courses, sections, enrollments);
        new ConsoleMenu(students, registration, schedules, reports).run();
    }
}
