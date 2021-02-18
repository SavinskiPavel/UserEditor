package command;

import main.CommandExecutor;
import main.ConsoleHelper;
import main.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveUserCommand implements Command {

    @Override
    public void execute()  {
        List<User> users = ViewCommand.getUsers();
        ConsoleHelper.writeMessage("Enter user id.");
        int request;
        try {
            request = Integer.parseInt(ConsoleHelper.readString()) - 1;
            String id = "id " + (request + 1);
            ConsoleHelper.writeMessage(id + users.get(request).toString());
            User user = users.get(request);
            ConsoleHelper.writeMessage("Specify folder to save this user.");
            String path = ConsoleHelper.readString()+"/"+user.getName()+user.getLastName()+".dat";
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(user);
            ConsoleHelper.writeMessage("User has been saved");
            ois.close();
            try {
                CommandExecutor.execute(ConsoleHelper.askOperation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IndexOutOfBoundsException | IOException e) {
            ConsoleHelper.writeMessage("User or directory cannot be found");
            try {
                CommandExecutor.execute(ConsoleHelper.askOperation());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage("Directory cannot be found");
            try {
                CommandExecutor.execute(ConsoleHelper.askOperation());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
