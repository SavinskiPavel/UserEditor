import main.CommandExecutor;
import main.ConsoleHelper;




public class UserEditor {

    public static void main(String[] args) throws Exception {
        CommandExecutor.execute(ConsoleHelper.askOperation());
    }
}
