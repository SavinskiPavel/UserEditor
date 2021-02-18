package main;

import status.Status;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bis.readLine();
    }

    public static Operation askOperation() {

        while (true) {
            try {
                ConsoleHelper.writeMessage("Please choose an operation desired:");
                ConsoleHelper.writeMessage("\t 1 - CREATE USER");
                ConsoleHelper.writeMessage("\t 2 - EDIT USER");
                ConsoleHelper.writeMessage("\t 3 - SAVE USER");
                ConsoleHelper.writeMessage("\t 4 - SAVE USERS");
                ConsoleHelper.writeMessage("\t 5 - DELETE USER");
                ConsoleHelper.writeMessage("\t 6 - VIEW USERS");
                ConsoleHelper.writeMessage("\t 7 - USER INFO");
                ConsoleHelper.writeMessage("\t 8 - EXIT");
                Integer i = Integer.parseInt(ConsoleHelper.readString().trim());
                return Operation.getOperation(i);
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }

    public static Status generalAskStatus () {
        while (true) {
            try {
                ConsoleHelper.writeMessage("Select the assigned status:");
                ConsoleHelper.writeMessage("\t 1 - USER (LEVEL 1)");
                ConsoleHelper.writeMessage("\t 2 - CUSTOMER (LEVEL 1)");
                ConsoleHelper.writeMessage("\t 3 - ADMIN (LEVEL 2)");
                ConsoleHelper.writeMessage("\t 4 - PROVIDER (LEVEL 2)");
                ConsoleHelper.writeMessage("\t 5 - SUPER_ADMIN (LEVEL 3)");
                Integer i = Integer.parseInt(ConsoleHelper.readString().trim());
                return Status.getStatus(i);
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }

    public static Status levelOneAskStatus () {
        while (true) {
            try {
                ConsoleHelper.writeMessage("Select the assigned status");
                ConsoleHelper.writeMessage("\t 1 - USER (LEVEL 1)");
                ConsoleHelper.writeMessage("\t 2 - CUSTOMER (LEVEL 1)");
                int i = Integer.parseInt(ConsoleHelper.readString().trim());
                if (i==1) {
                    return Status.getStatus(i);
                } else if (i==2) {
                    return Status.getStatus(i);
                } else {
                    ConsoleHelper.writeMessage("Please specify valid data.");
                }
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }

    public static Status levelTwoAskStatus () {
        while (true) {
            try {
                ConsoleHelper.writeMessage("Select the assigned status");
                ConsoleHelper.writeMessage("\t 3 - ADMIN (LEVEL 2)");
                ConsoleHelper.writeMessage("\t 4 - PROVIDER (LEVEL 2)");
                int i = Integer.parseInt(ConsoleHelper.readString().trim());
                if (i == 3) {
                    return Status.getStatus(i);
                } else if (i==4) {
                    return Status.getStatus(i);
                } else {
                    ConsoleHelper.writeMessage("Please specify valid data.");
                }
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }
}

