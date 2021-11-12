public enum Ivanov {
    NAME("IVANOV IVAN"), CURR("Java Developer"), START_DATE("01.06.2020");
    private final String value;

    Ivanov(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
