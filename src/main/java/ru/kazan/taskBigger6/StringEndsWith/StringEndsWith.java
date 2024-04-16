package ru.kazan.taskBigger6.StringEndsWith;

public class StringEndsWith {

    public static boolean isEndsWith(String string, String substring) {
        return string.endsWith(substring);
    }

    public static void main(String[] args) {
        System.out.println(isEndsWith("hello", "lo"));
    }
}
