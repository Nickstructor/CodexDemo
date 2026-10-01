import repository.*;
import util.SampleData;
public class SampleDataTest {
    public static void run() {
        StudentRepository students = new StudentRepository();
        CourseRepository courses = new CourseRepository();
        SectionRepository sections = new SectionRepository();
        EnrollmentRepository enrollments = new EnrollmentRepository();
        SampleData.populate(students, courses, sections, enrollments);
        TestSupport.equal(3, students.findAll().size());
        TestSupport.equal(4, courses.findAll().size());
        TestSupport.equal(4, sections.findAll().size());
        TestSupport.equal(2, enrollments.findAll().size());
        TestSupport.equal(true, enrollments.contains(1001, "JAVA-A"));
        TestSupport.equal(true, enrollments.contains(1002, "WEB-A"));
        TestSupport.equal(0, enrollments.findByStudent(1003).size());
        enrollments.remove(1001, "JAVA-A");
        EnrollmentRepository fresh = new EnrollmentRepository();
        SampleData.populate(new StudentRepository(), new CourseRepository(), new SectionRepository(), fresh);
        TestSupport.equal(true, fresh.contains(1001, "JAVA-A"));
        TestSupport.equal(false, enrollments.contains(1001, "JAVA-A"));
    }
}
