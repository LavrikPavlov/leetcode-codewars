package ru.kazan.level7.RegexValidatePINCode;


import java.util.regex.Pattern;

public class RegexValidatePINCode {

    private static final Pattern REGEX = Pattern.compile("^\\d{4}$|\\d{6}");

    public static void main(String[] args) {
        System.out.println(validate("1f54"));
        System.out.println(validate("154"));
        System.out.println(validate("1542"));
        System.out.println(validate("15422"));
        System.out.println(validate("154222"));
    }

    private static boolean validate(String pin){
        return REGEX.matcher(pin).matches();
    }
}
