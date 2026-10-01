public class RepositoryTest {
    public static void run() {
        Fixture f = new Fixture();
        TestSupport.equal("Alex", f.students.findById(1001).getName());
        TestSupport.equal(null, f.students.findById(9999));
        f.students.findAll().clear();
        TestSupport.equal(3, f.students.findAll().size());
        f.registration.register(1001, "JAVA-A");
        TestSupport.equal(1, f.enrollments.countBySection("JAVA-A"));
        f.enrollments.findAll().clear();
        TestSupport.equal(1, f.enrollments.findAll().size());
    }
}
