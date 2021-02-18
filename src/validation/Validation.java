package validation;

import main.ConsoleHelper;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String EMAIL_PATTERN = "[a-zA-Z0-9[!#$%&'()*+,/\\-_.\"]]+@[a-zA-Z0-9[!#$%&'()*+,/\\-_\"]]+\\.[a-zA-Z0-9[!#$%&'()*+,/\\-_\".]]+";
    private static final String TELEPHONE_PATTERN="375\\d{9}";

    public static String validationByEmail() throws IOException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        while (true) {
            String email = ConsoleHelper.readString();
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return email;
            } else {

                ConsoleHelper.writeMessage("Email is not valid. Enter email");
            }
        }
    }
    public static String validationByTelephone() throws IOException {
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        while (true) {
            String telephone = ConsoleHelper.readString();
            Matcher matcher = pattern.matcher(telephone);
            if (matcher.matches()) {
                return telephone;
            } else {
                ConsoleHelper.writeMessage("Phone number is not valid. Enter three numbers (number must start with \"375\" and have 12 digits).");
            }
        }
    }

}
