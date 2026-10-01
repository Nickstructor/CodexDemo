import model.*;
import repository.*;
import service.*;
import java.time.*;
public class Fixture {
    final StudentRepository students = new StudentRepository();
    final CourseRepository courses = new CourseRepository();
    final SectionRepository sections = new SectionRepository();
    final EnrollmentRepository enrollments = new EnrollmentRepository();
    final ScheduleService schedules = new ScheduleService(enrollments, sections);
    final RegistrationService registration = new RegistrationService(students, sections, enrollments, schedules);
    public Fixture() {
        students.add(new Student(1001, "Alex", "alex@example.test"));
        students.add(new Student(1002, "Sam", "sam@example.test"));
        students.add(new Student(1003, "Jordan", "jordan@example.test"));
        sections.add(section("JAVA-A", DayOfWeek.MONDAY, "09:00", "10:00", 2));
        sections.add(section("NET-A", DayOfWeek.MONDAY, "09:30", "10:30", 2));
        sections.add(section("DB-A", DayOfWeek.MONDAY, "10:00", "11:00", 2));
        sections.add(section("WEB-A", DayOfWeek.TUESDAY, "09:00", "10:00", 1));
    }
    Section section(String id, DayOfWeek day, String start, String end, int capacity) {
        return new Section(id, "COMP101", 1, capacity,
            new MeetingTime(day, LocalTime.parse(start), LocalTime.parse(end)));
    }
}
