package util;
public final class InputValidator {
    private InputValidator() { }
    public static int positiveId(String value) {
        try {
            int id = Integer.parseInt(value.trim());
            if (id > 0) { return id; }
        } catch (NumberFormatException ignored) { }
        throw new IllegalArgumentException("Enter a positive numeric student ID");
    }
}
