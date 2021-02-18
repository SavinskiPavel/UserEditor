package main;

import command.*;


import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

    static {
        allKnownCommandsMap.put(Operation.CREATE, new CreateCommand());
        allKnownCommandsMap.put(Operation.EDIT, new EditCommand());
        allKnownCommandsMap.put(Operation.SAVE_USER, new SaveUserCommand());
        allKnownCommandsMap.put(Operation.SAVE_USERS, new SaveUsersCommand());
        allKnownCommandsMap.put(Operation.DELETE, new DeleteCommand());
        allKnownCommandsMap.put(Operation.VIEW, new ViewCommand());
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {

    }

    public static void execute(Operation operation) throws Exception {
        allKnownCommandsMap.get(operation).execute();
    }
}

