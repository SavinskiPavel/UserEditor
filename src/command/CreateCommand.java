package command;
import main.CommandExecutor;
import main.ConsoleHelper;
import main.User;
import status.Status;
import status.StatusAssignerer;
import validation.Validation;
import java.util.ArrayList;
import java.util.List;

public class CreateCommand implements Command {

    @Override
    public void execute() throws Exception {
        List<String> phones = new ArrayList<>();
        ConsoleHelper.writeMessage("Enter First Name.");
        String name = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Enter Last Name.");
        String lastName = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Enter email.");
        String email = Validation.validationByEmail();
        List<Status> statusList = StatusAssignerer.assignStatus();
        ConsoleHelper.writeMessage("How many phone numbers do you want to assign (min 1, max 3)?");
        //noinspection InfiniteLoopStatement
        while(true) {
            String numbers = ConsoleHelper.readString();
            switch (numbers) {
                case "1" -> {
                    ConsoleHelper.writeMessage("Enter phone number (number must start with \"375\" and have 12 digits).");
                    phones.add(Validation.validationByTelephone());
                    ViewCommand.add(new User(name, lastName, email, phones, statusList));
                    ConsoleHelper.writeMessage("New user has been created.");
                    CommandExecutor.execute(ConsoleHelper.askOperation());
                }
                case "2" -> {
                    ConsoleHelper.writeMessage("Enter two numbers (number must start with \"375\" and have 12 digits).");
                    phones.add(Validation.validationByTelephone());
                    phones.add(Validation.validationByTelephone());
                    ViewCommand.add(new User(name, lastName, email, phones, statusList));
                    ConsoleHelper.writeMessage("New user has been created.");
                    CommandExecutor.execute(ConsoleHelper.askOperation());
                }
                case "3" -> {
                    ConsoleHelper.writeMessage("Enter three numbers (number must start with \"375\" and have 12 digits).");
                    phones.add(Validation.validationByTelephone());
                    phones.add(Validation.validationByTelephone());
                    phones.add(Validation.validationByTelephone());
                    ViewCommand.add(new User(name, lastName, email, phones,statusList));
                    ConsoleHelper.writeMessage("New user has been created.");
                    CommandExecutor.execute(ConsoleHelper.askOperation());
                }
                default -> ConsoleHelper.writeMessage("Please enter valid data.");
            }
        }
    }
}







