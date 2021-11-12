public enum Sidorov {
    NAME ("SIDOROV IVAN"), CURR ("AQE"), START_DATE ("01.06.2020");
    private String value;

   Sidorov(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
