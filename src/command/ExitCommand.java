package command;

import main.ConsoleHelper;

import java.io.IOException;


public class ExitCommand implements Command {

    @Override
    public void execute() throws IOException {
        ConsoleHelper.writeMessage("Goodbye!");
        ConsoleHelper.bis.close();
        System.exit(0);
    }
}
