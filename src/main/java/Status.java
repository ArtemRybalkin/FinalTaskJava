public enum Status {

    COMPLETE ("complete"),
    NOT_COMPLETE ("not complete ");

    private final String status;

    Status(String value) {
        this.status = value;
    }

    public String getStatus() {
        return status;
    }

}
