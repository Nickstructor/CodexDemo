package util;

import model.*;
import repository.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

/** Creates fictional objects in fresh repositories at application startup. */
public final class SampleData {
    private SampleData() { }

    public static void populate(StudentRepository students, CourseRepository courses,
            SectionRepository sections, EnrollmentRepository enrollments) {
        students.add(new Student(1001, "Alex Chen", "alex@example.test"));
        students.add(new Student(1002, "Sam Patel", "sam@example.test"));
        students.add(new Student(1003, "Jordan Lee", "jordan@example.test"));
        courses.add(new Course("COMP101", "Java Programming", 3));
        courses.add(new Course("COMP102", "Networking", 3));
        courses.add(new Course("COMP103", "Databases", 3));
        courses.add(new Course("COMP104", "Web Development", 3));
        sections.add(section("JAVA-A", "COMP101", 1, 2, DayOfWeek.MONDAY, "09:00", "10:00"));
        sections.add(section("NET-A", "COMP102", 2, 2, DayOfWeek.MONDAY, "09:30", "10:30"));
        sections.add(section("DB-A", "COMP103", 1, 2, DayOfWeek.MONDAY, "10:00", "11:00"));
        sections.add(section("WEB-A", "COMP104", 2, 1, DayOfWeek.TUESDAY, "09:00", "10:00"));
        enrollments.add(new Enrollment(1001, "JAVA-A"));
        enrollments.add(new Enrollment(1002, "WEB-A"));
    }

    private static Section section(String id, String courseCode, int instructorId, int capacity,
            DayOfWeek day, String start, String end) {
        return new Section(id, courseCode, instructorId, capacity,
            new MeetingTime(day, LocalTime.parse(start), LocalTime.parse(end)));
    }
}
