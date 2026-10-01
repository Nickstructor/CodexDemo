package service;
import model.Enrollment;
import model.Section;
import repository.EnrollmentRepository;
import repository.SectionRepository;
import java.util.ArrayList;
import java.util.List;
public class ScheduleService {
    private final EnrollmentRepository enrollments;
    private final SectionRepository sections;
    public ScheduleService(EnrollmentRepository enrollments, SectionRepository sections) {
        this.enrollments = enrollments;
        this.sections = sections;
    }
    public List<Section> getSchedule(int studentId) {
        List<Section> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments.findByStudent(studentId)) {
            Section section = sections.findById(enrollment.getSectionId());
            if (section != null) { result.add(section); }
        }
        return result;
    }
}
