package status;

import main.ConsoleHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatusAssignerer {

    public static List<Status> assignStatus() throws IOException {
        List<Status> statusList = new ArrayList<>();
        Status status = ConsoleHelper.generalAskStatus();
        while (true) {
            switch (status) {
                case USER, CUSTOMER -> {
                    statusList.add(status);
                    ConsoleHelper.writeMessage("Do you want to enter status from another level? Write \"yes\" or \"no\".");
                    while (true) {
                        switch (ConsoleHelper.readString()) {
                            case "yes":
                                status = ConsoleHelper.levelTwoAskStatus();
                                statusList.add(status);
                                return statusList;
                            case "no":
                                return statusList;
                            default:
                                ConsoleHelper.writeMessage("Please specify valid data.");
                        }
                    }
                }
                case ADMIN, PROVIDER -> {
                    statusList.add(status);
                    ConsoleHelper.writeMessage("Do you want to enter status from another level? Write \"yes\" or \"no\".");
                    while (true) {
                        switch (ConsoleHelper.readString()) {
                            case "yes":
                                status = ConsoleHelper.levelOneAskStatus();
                                statusList.add(status);
                                return statusList;
                            case "no":
                                return statusList;
                            default:
                                ConsoleHelper.writeMessage("Please specify valid data.");
                        }
                    }
                }
                case SUPER_ADMIN -> {
                    statusList.add(status);
                    return statusList;
                }
                default -> ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }
}
