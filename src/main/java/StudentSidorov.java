public enum StudentSidorov {
    NAME ("SIDOROV IVAN"), CURR ("AQE"), START_DATE ("01.06.2020");
    private String value;

   StudentSidorov(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
