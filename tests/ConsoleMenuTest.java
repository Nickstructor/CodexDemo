import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import service.ReportService;
import ui.ConsoleMenu;

public class ConsoleMenuTest {
    private static final String MENU =
        "1 Students  2 Sections  3 Register  4 Drop  5 Schedule  0 Exit";

    public static void run() {
        checkMenu("0\n", 1);
        checkMenu("1\n0\n", 2);
        checkMenu("", 1);
    }

    private static void checkMenu(String input, int expectedMenuCount) {
        Fixture fixture = new Fixture();
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        ByteArrayInputStream suppliedInput = new ByteArrayInputStream(
            input.getBytes(StandardCharsets.UTF_8));
        InputStream checkedInput = new InputStream() {
            private boolean firstRead = true;

            @Override
            public int read() {
                // Check before reading input so buffering cannot hide the startup bug.
                if (firstRead) {
                    firstRead = false;
                    TestSupport.equal(true,
                        capturedOutput.toString(StandardCharsets.UTF_8).startsWith(MENU));
                }
                return suppliedInput.read();
            }
        };
        try (PrintStream output = new PrintStream(capturedOutput, true, StandardCharsets.UTF_8)) {
            System.setIn(checkedInput);
            System.setOut(output);
            ReportService reports = new ReportService(
                fixture.courses, fixture.sections, fixture.enrollments);
            new ConsoleMenu(fixture.students, fixture.registration, fixture.schedules, reports).run();
            String transcript = capturedOutput.toString(StandardCharsets.UTF_8);
            int menuCount = 0;
            for (String line : transcript.split("\\R")) {
                if (line.equals(MENU)) {
                    menuCount++;
                }
            }
            TestSupport.equal(expectedMenuCount, menuCount);
            TestSupport.equal(true, transcript.contains(
                "Goodbye. Restart the application to reset the sample data."));
            if (input.startsWith("1")) {
                TestSupport.equal(true, transcript.contains("1001 Alex"));
            }
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
