package common;

public class Validation {
    public static boolean checkEmail(String email) {
        String regex = "^[a-zA-Z0-9][a-zA-Z0-9\\.\\-_]+@[a-zA-Z](\\.[a-zA-Z]+){1,3}";
        return email.matches(regex);
    }
    public static boolean checkNumber(int number) {
        if(number < 0) {
            return false;
        }
        return true;
    }

    public static boolean checkDate(String date) {
        String regex = "^\\d{1,2}[/]\\d{1,2}[/]\\d{4}$";
        return date.matches(regex);
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        String regex1 = "^[09][1|0][0-9]{7}$" ;
        String regex2 = "^\\([84]\\)\\+[9][1|2][0-9]{7}$" ;

        if(phoneNumber.matches(regex1) && phoneNumber.matches(regex2)) {
            return  true;
        }
        return false;
    }

    public static boolean checkNickName(String nickName) {
        String regex = "^[a-zA-Z0-9 ]{6,8}$" ;

        return nickName.matches(regex);
    }

    public static boolean checkName(String name) {
        String regex = "^[a-zA-Z ]+$" ;

        return name.matches(regex);
    }

}
