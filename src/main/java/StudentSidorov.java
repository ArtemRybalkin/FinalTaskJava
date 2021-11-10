public enum StudentSidorov {
    NAME ("SIDOROV IVAN"), CURRICULUM ("AQE"), START_DATE ("01 01 2020"), TestDesign ("10"),
    PageObject ("16"), Selenium ("16");
    private String value;

   StudentSidorov(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
