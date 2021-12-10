package _19_stringAndRegex.exercise.validateClassName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameExample {
//    Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P
//    Không chứa các ký tự đặc biệt
//    Theo sau ký tự bắt đầu là 4 ký tự số
//    Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M

    private static final String className_regex = "^[CAP][0-9]{4}[GHIKLM]$";

    public ClassNameExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern =  Pattern.compile(className_regex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
