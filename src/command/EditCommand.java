package command;

import main.CommandExecutor;
import main.ConsoleHelper;
import main.User;
import status.Status;
import status.StatusAssignerer;
import validation.Validation;
import java.util.ArrayList;
import java.util.List;

public class EditCommand implements Command {

    @Override
    public void execute() throws Exception {
        List<User> users = ViewCommand.getUsers();
        ConsoleHelper.writeMessage("Please enter user id");
        int request;
        try {
            request = Integer.parseInt(ConsoleHelper.readString()) - 1;
            String id = "id " + (request + 1);
            ConsoleHelper.writeMessage(id + users.get(request).toString());
            User user = users.get(request);
            ConsoleHelper.writeMessage("Enter new FirstName.");
            String newName = ConsoleHelper.readString();
            user.setName(newName);
            ConsoleHelper.writeMessage("Enter new LastName.");
            String newLastName = ConsoleHelper.readString();
            user.setLastName(newLastName);
            ConsoleHelper.writeMessage("Enter new email.");
            String newEmail = Validation.validationByEmail();
            user.setEmail(newEmail);
            List<Status> newStatusList = StatusAssignerer.assignStatus();
            user.setStatus(newStatusList);
            ConsoleHelper.writeMessage("How many phone numbers do you want to assign (min 1, max 3)?");
            List<String> newPhones = new ArrayList<>();
            //noinspection InfiniteLoopStatement
            while (true) {
                String numbers = ConsoleHelper.readString();
                switch (numbers) {
                    case "1" -> {
                        ConsoleHelper.writeMessage("Enter phone number (number must start with \"375\" and have 12 digits).");
                        newPhones.add(Validation.validationByTelephone());
                        user.setPhones(newPhones);
                        ConsoleHelper.writeMessage("User has been editted.");
                        CommandExecutor.execute(ConsoleHelper.askOperation());
                    }
                    case "2" -> {
                        ConsoleHelper.writeMessage("Enter two numbers (number must start with \"375\" and have 12 digits).");
                        user.getPhones().clear();
                        newPhones.add(Validation.validationByTelephone());
                        newPhones.add(Validation.validationByTelephone());
                        user.setPhones(newPhones);
                        ConsoleHelper.writeMessage("User has been edited.");
                        CommandExecutor.execute(ConsoleHelper.askOperation());
                    }
                    case "3" -> {
                        ConsoleHelper.writeMessage("Enter three numbers. (number must start with \"375\" and have 12 digits).");
                        user.getPhones().clear();
                        newPhones.add(Validation.validationByTelephone());
                        newPhones.add(Validation.validationByTelephone());
                        newPhones.add(Validation.validationByTelephone());
                        user.setPhones(newPhones);
                        ConsoleHelper.writeMessage("User has been edited.");
                        CommandExecutor.execute(ConsoleHelper.askOperation());
                    }
                    default -> ConsoleHelper.writeMessage("Please enter valid data.");
                }
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("User cannot be found");
            CommandExecutor.execute(ConsoleHelper.askOperation());
        }
    }
}



