public class AllTests {
    public static void main(String[] args) {
        RegistrationServiceTest.run();
        ScheduleServiceTest.run();
        RepositoryTest.run();
        SampleDataTest.run();
        ConsoleMenuTest.run();
        System.out.println("PASS: " + TestSupport.count() + " checks");
    }
}
