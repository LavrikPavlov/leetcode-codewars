package ru.kazan.taskBigger6.CreditCardMask;

public class CreditCardMask {

    public static String maskify(String str) {
        if(str.length() <= 4)
            return str;
        return "#".repeat(str.length() - 4) + str.substring(str.length() - 4);
    }

    public static void main(String[] args) {
        System.out.println(maskify("123"));
        System.out.println(maskify("1234512345123451234512345123451234512345"));
    }
}
