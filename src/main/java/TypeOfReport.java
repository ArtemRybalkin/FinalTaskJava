public enum TypeOfReport {
    shortReport ("Short"),
    fullReport ("Full");
    private final String typeOfReport;
    TypeOfReport(String value) {
        this.typeOfReport = value;
    }
    public String getTypeOfReport() {
        return typeOfReport;
    }
}
