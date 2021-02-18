package command;

import main.CommandExecutor;
import main.ConsoleHelper;
import main.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveUsersCommand implements Command {
    @Override
    public void execute()  {
        List<User> users = ViewCommand.getUsers();
        try {
            ConsoleHelper.writeMessage("Specify folder to save all users.");
            String path = ConsoleHelper.readString();
            for (User user : users) {
                FileOutputStream fos = new FileOutputStream(path+"/"+user.getName()+user.getLastName()+".dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(user);
                fos.close();
                oos.close();
            }
            ConsoleHelper.writeMessage("Users had been saved.");
            try {
                CommandExecutor.execute(ConsoleHelper.askOperation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IndexOutOfBoundsException | IOException e) {
            ConsoleHelper.writeMessage("Users or directory cannot be found");
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




