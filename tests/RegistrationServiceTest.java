public class RegistrationServiceTest {
    public static void run() {
        Fixture f = new Fixture();
        TestSupport.equal("Student not found", f.registration.register(9999, "JAVA-A"));
        TestSupport.equal("Section not found", f.registration.register(1001, "UNKNOWN"));
        TestSupport.equal("Registered", f.registration.register(1001, "JAVA-A"));
        TestSupport.equal("Already registered", f.registration.register(1001, "JAVA-A"));
        TestSupport.equal(1, f.enrollments.findAll().size());
        TestSupport.equal("Dropped", f.registration.drop(1001, "JAVA-A"));
        TestSupport.equal("Enrollment not found", f.registration.drop(1001, "JAVA-A"));
        TestSupport.equal(0, f.enrollments.findAll().size());
    }
}
