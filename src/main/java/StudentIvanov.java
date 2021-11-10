public enum StudentIvanov {
    NAME ("IVANOV IVAN"), CURRICULUM ("Java Developer"), START_DATE ("01.06.2020"), JAVA ("16"),
    JDBC ("24"), Spring ("16"), COURSE ("");
    private String value;

   StudentIvanov(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
