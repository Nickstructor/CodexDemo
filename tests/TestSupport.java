public final class TestSupport {
    private static int checks;
    private TestSupport() { }
    public static void equal(Object expected, Object actual) {
        checks++;
        if (!java.util.Objects.equals(expected, actual)) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }
    public static int count() { return checks; }
}
