package command;

import main.CommandExecutor;
import main.ConsoleHelper;
import main.User;
import java.util.List;

public class InfoCommand implements Command {

    @Override
    public void execute() throws Exception {
        List<User> users = ViewCommand.getUsers();
        ConsoleHelper.writeMessage("Please enter Last Name");
        String request = ConsoleHelper.readString();
        int count = 0;
        for (User user : users) {
            if (user.getLastName().equalsIgnoreCase(request)) {
                ConsoleHelper.writeMessage("id " + (users.indexOf(user) + 1) + user.toString());
                count++;
            }
        }
        if (count==0) {
            ConsoleHelper.writeMessage("User cannot be found.");
        }
        CommandExecutor.execute(ConsoleHelper.askOperation());
    }
}
