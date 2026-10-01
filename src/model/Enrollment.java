package model;

/** Immutable enrollment data used by the registration application. */
public class Enrollment {
    private final int studentId;
    private final String sectionId;

    public Enrollment(int studentId, String sectionId) {
        this.studentId = studentId;
        this.sectionId = sectionId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSectionId() {
        return sectionId;
    }
}
