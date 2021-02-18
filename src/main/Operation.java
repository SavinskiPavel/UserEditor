package main;

public enum Operation {
    CREATE,
    EDIT,
    SAVE_USER,
    SAVE_USERS,
    DELETE,
    VIEW,
    INFO,
    EXIT;

    public static Operation getOperation(Integer i) {
        return switch (i) {
            case 1 -> Operation.CREATE;
            case 2 -> Operation.EDIT;
            case 3 -> Operation.SAVE_USER;
            case 4 -> Operation.SAVE_USERS;
            case 5 -> Operation.DELETE;
            case 6 -> Operation.VIEW;
            case 7 -> Operation.INFO;
            case 8 -> Operation.EXIT;
            default -> throw new IllegalArgumentException();
        };
    }
}

