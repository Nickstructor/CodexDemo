package model;

/** Immutable section data used by the registration application. */
public class Section {
    private final String id;
    private final String courseCode;
    private final int instructorId;
    private final int capacity;
    private final MeetingTime meetingTime;

    public Section(String id, String courseCode, int instructorId, int capacity, MeetingTime meetingTime) {
        this.id = id;
        this.courseCode = courseCode;
        this.instructorId = instructorId;
        this.capacity = capacity;
        this.meetingTime = meetingTime;
    }

    public String getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public int getCapacity() {
        return capacity;
    }

    public MeetingTime getMeetingTime() {
        return meetingTime;
    }
}
