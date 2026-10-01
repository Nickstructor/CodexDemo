public class ScheduleServiceTest {
    public static void run() {
        Fixture f = new Fixture();
        TestSupport.equal(0, f.schedules.getSchedule(1001).size());
        f.registration.register(1001, "JAVA-A");
        TestSupport.equal("JAVA-A", f.schedules.getSchedule(1001).get(0).getId());
        TestSupport.equal(0, f.schedules.getSchedule(1002).size());
    }
}
