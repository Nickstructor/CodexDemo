package service;
import model.Enrollment;
import repository.StudentRepository;
import repository.SectionRepository;
import repository.EnrollmentRepository;
/** Business operations return a message for the console to display. */
public class RegistrationService {
    private final StudentRepository students;
    private final SectionRepository sections;
    private final EnrollmentRepository enrollments;
    private final ScheduleService schedules;
    public RegistrationService(StudentRepository students, SectionRepository sections,
            EnrollmentRepository enrollments, ScheduleService schedules) {
        this.students = students;
        this.sections = sections;
        this.enrollments = enrollments;
        this.schedules = schedules;
    }
    public String register(int studentId, String sectionId) {
        if (students.findById(studentId) == null) { return "Student not found"; }
        if (sections.findById(sectionId) == null) { return "Section not found"; }
        if (enrollments.contains(studentId, sectionId)) { return "Already registered"; }
        enrollments.add(new Enrollment(studentId, sectionId));
        return "Registered";
    }
    public String drop(int studentId, String sectionId) {
        if (students.findById(studentId) == null) { return "Student not found"; }
        return enrollments.remove(studentId, sectionId) ? "Dropped" : "Enrollment not found";
    }
}
