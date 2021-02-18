package status;

public enum Status {
    USER,
    CUSTOMER,
    ADMIN,
    PROVIDER,
    SUPER_ADMIN;

    public static Status getStatus(Integer i) {
        return switch (i) {
            case 1 -> Status.USER;
            case 2 -> Status.CUSTOMER;
            case 3 -> Status.ADMIN;
            case 4 -> Status.PROVIDER;
            case 5 -> Status.SUPER_ADMIN;
            default -> throw new IllegalArgumentException();
        };
    }
}

