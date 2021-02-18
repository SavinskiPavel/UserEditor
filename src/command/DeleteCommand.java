package command;

import main.CommandExecutor;
import main.ConsoleHelper;
import main.User;

import java.util.List;

public class DeleteCommand implements Command {
    @Override
    public void execute() throws Exception {
        List<User> users = ViewCommand.getUsers();
        ConsoleHelper.writeMessage("Please enter user id");
        int request;
        try {
            request = Integer.parseInt(ConsoleHelper.readString()) - 1;
            String id = "id " + (request + 1);
            ConsoleHelper.writeMessage(id + users.get(request).toString());
            users.remove(users.get(request));
            ConsoleHelper.writeMessage("User has been deleted");
            CommandExecutor.execute(ConsoleHelper.askOperation());
        } catch (Exception e) {
            ConsoleHelper.writeMessage("User cannot be found");
            CommandExecutor.execute(ConsoleHelper.askOperation());
        }
    }
}
