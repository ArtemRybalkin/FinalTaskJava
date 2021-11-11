public enum StudentSidorov {
    NAME ("SIDOROV IVAN"), CURRICULUM ("AQE"), START_DATE ("01.01.2020");
    private String value;

   StudentSidorov(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
