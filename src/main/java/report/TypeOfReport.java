package report;

public enum TypeOfReport {

    SHORT_REPORT("Short"),
    FULL_REPORT("Full");
    private final String type;

    TypeOfReport(String value) {

        this.type = value;
    }

    public static TypeOfReport getType(String textFromConsole) {
        if (textFromConsole.isEmpty() || textFromConsole.equals("0")) {
            return SHORT_REPORT;
        } else return FULL_REPORT;
    }
}
