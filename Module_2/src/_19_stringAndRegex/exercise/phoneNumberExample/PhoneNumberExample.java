package _19_stringAndRegex.exercise.phoneNumberExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
//    (xx)-(0xxxxxxxxx)
//    x là ký tự số
//    Không chứa các ký tự đặc biệt
    private static final String phoneNumber_regex = "^[(][0-9]{2}[)][-][(][0][0-9]{9}[)]$";

    public PhoneNumberExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern =  Pattern.compile(phoneNumber_regex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
