public enum Status {
    APPROVED("Approved"),
    REJECTED("Rejected"),
    OVERDUE("Overdue"),
    PENDING("Pending");

    public final String value;

    private Status(String value) {
        this.value = value;
    }
}
