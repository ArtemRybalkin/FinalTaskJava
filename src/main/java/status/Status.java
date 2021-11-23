package status;

public enum Status {

    COMPLETE("complete"),
    NOT_COMPLETE("not complete");

    private final String statusType;

    Status(String value) {
        this.statusType = value;
    }

    public String getStatusType() {
        return statusType;
    }



}
