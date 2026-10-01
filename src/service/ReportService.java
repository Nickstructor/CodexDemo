package service;
import model.Course;
import model.Section;
import repository.CourseRepository;
import repository.SectionRepository;
import repository.EnrollmentRepository;
import java.util.ArrayList;
import java.util.List;
public class ReportService {
    private final CourseRepository courses;
    private final SectionRepository sections;
    private final EnrollmentRepository enrollments;
    public ReportService(CourseRepository courses, SectionRepository sections, EnrollmentRepository enrollments) {
        this.courses = courses;
        this.sections = sections;
        this.enrollments = enrollments;
    }
    public List<String> sectionSummary() {
        List<String> lines = new ArrayList<>();
        for (Section section : sections.findAll()) {
            Course course = courses.findById(section.getCourseCode());
            String title = course == null ? section.getCourseCode() : course.getTitle();
            lines.add(section.getId() + " " + title + " " + section.getMeetingTime()
                + " seats " + enrollments.countBySection(section.getId()) + "/" + section.getCapacity());
        }
        return lines;
    }
}
