public enum StudentIvanov {
    NAME ("IVANOV IVAN"), CURRICULUM ("Java Developer"), START_DATE ("01.06.2020");
    private String value;

   StudentIvanov(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
