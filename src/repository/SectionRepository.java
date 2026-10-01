package repository;
import model.Section;
import java.util.ArrayList;
import java.util.List;
/** In-memory repository. Callers receive a copy of the collection. */
public class SectionRepository {
    private final List<Section> items = new ArrayList<>();
    public void add(Section item) { items.add(item); }
    public Section findById(String id) {
        for (Section item : items) {
            if (item.getId().equals(id)) { return item; }
        }
        return null;
    }
    public List<Section> findAll() { return new ArrayList<>(items); }
}
