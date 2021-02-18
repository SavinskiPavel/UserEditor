package command;

import main.CommandExecutor;
import main.ConsoleHelper;
import main.User;
import java.util.ArrayList;
import java.util.List;


public class ViewCommand implements Command {
    private static List<User> users = new ArrayList<>();


    @Override
    public void execute() throws Exception {

        for (User user : users) {
            String id = "id " + (users.indexOf(user) + 1);
            ConsoleHelper.writeMessage(id + user.toString());
        }
        CommandExecutor.execute(ConsoleHelper.askOperation());
    }

    public static void add (User user) {
        users.add(user);
    }

    public static List<User> getUsers() {
        return users;
    }
}
