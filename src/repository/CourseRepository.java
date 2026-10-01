package repository;
import model.Course;
import java.util.ArrayList;
import java.util.List;
/** In-memory repository. Callers receive a copy of the collection. */
public class CourseRepository {
    private final List<Course> items = new ArrayList<>();
    public void add(Course item) { items.add(item); }
    public Course findById(String id) {
        for (Course item : items) {
            if (item.getCode().equals(id)) { return item; }
        }
        return null;
    }
    public List<Course> findAll() { return new ArrayList<>(items); }
}
