package repository;
import model.Student;
import java.util.ArrayList;
import java.util.List;
/** In-memory repository. Callers receive a copy of the collection. */
public class StudentRepository {
    private final List<Student> items = new ArrayList<>();
    public void add(Student item) { items.add(item); }
    public Student findById(int id) {
        for (Student item : items) {
            if (item.getId() == id) { return item; }
        }
        return null;
    }
    public List<Student> findAll() { return new ArrayList<>(items); }
}
