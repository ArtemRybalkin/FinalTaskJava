package report;

public enum TypeOfReport {
    SHORT_REPORT("Short"),
    FULL_REPORT("Full");
    private final String typeOfReport;
    TypeOfReport(String value) {
        this.typeOfReport = value;
    }
    public String getTypeOfReport() {
        return typeOfReport;
    }
}
