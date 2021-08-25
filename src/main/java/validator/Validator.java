package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // Validate if all fields are filled
    public static boolean validate(String... fields) {
        for (String field : fields) {
            if (field == null || field.length() == 0) {
                return false;
            }
        }
        return true;
    }

    // Validate if mobile number is 10 digits long and starts with either 6/7/8/9
    public static boolean validateMobileNumber(long mobileNumber) {
        String mobile = String.valueOf(mobileNumber);

        Pattern pattern = Pattern.compile("^[6-9]\\d{9}");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();

    }

    // Validate if name does not contain special characters
    public static boolean validateName(String name) {
          return Pattern.matches("[A-Za-z]+", name);
    }

    public static boolean emailIdValidator(String mailId) {
        Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
        Matcher matcher = pattern.matcher(mailId);
        return matcher.matches();
    }

    // Validate if amount is a multiple of 100 (minimum denomination)
    public static boolean validateMoney(long amount) {
        return amount % 100 != 0;
    }
}
