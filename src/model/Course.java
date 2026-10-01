package model;

/** Immutable course data used by the registration application. */
public class Course {
    private final String code;
    private final String title;
    private final int credits;

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }
}
