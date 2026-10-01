package repository;
import model.Enrollment;
import java.util.ArrayList;
import java.util.List;
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();
    public void add(Enrollment enrollment) { enrollments.add(enrollment); }
    public List<Enrollment> findAll() { return new ArrayList<>(enrollments); }
    public List<Enrollment> findByStudent(int studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) { result.add(enrollment); }
        }
        return result;
    }
    public boolean contains(int studentId, String sectionId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId && enrollment.getSectionId().equals(sectionId)) {
                return true;
            }
        }
        return false;
    }
    public int countBySection(String sectionId) {
        int count = 0;
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getSectionId().equals(sectionId)) { count++; }
        }
        return count;
    }
    public boolean remove(int studentId, String sectionId) {
        return enrollments.removeIf(e -> e.getStudentId() == studentId && e.getSectionId().equals(sectionId));
    }
}
