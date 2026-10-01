package model;
import java.time.DayOfWeek;
import java.time.LocalTime;
/** A single weekly meeting. End time is exclusive. Overnight meetings are unsupported. */
public class MeetingTime {
    private final DayOfWeek day;
    private final LocalTime start;
    private final LocalTime end;
    public MeetingTime(DayOfWeek day, LocalTime start, LocalTime end) {
        if (day == null || start == null || end == null || !start.isBefore(end)) {
            throw new IllegalArgumentException("Meeting must have a day and start before end");
        }
        this.day = day;
        this.start = start;
        this.end = end;
    }
    public DayOfWeek getDay() { return day; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
    @Override
    public String toString() { return day + " " + start + "-" + end; }
}
