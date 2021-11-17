package report;

public enum TypeOfReport {
    SHORT_REPORT("Short"),
    FULL_REPORT("Full");
    private final String type;
    TypeOfReport(String value) {
        this.type = value;
    }
    public String getType() {
        return type;
    }
}
