package _19_stringAndRegex.practice.p2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private static final String account_regex = "^[_a-z0-9]{6,}$";

    public AccountExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern =  Pattern.compile(account_regex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
