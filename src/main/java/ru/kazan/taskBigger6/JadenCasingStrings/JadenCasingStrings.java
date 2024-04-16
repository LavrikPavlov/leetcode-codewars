package ru.kazan.taskBigger6.JadenCasingStrings;

public class JadenCasingStrings {

    public static String allWorldInCase(String input) {
        if(input == null || input.isEmpty()) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ");

        for (int i = 0; i < words.length; i++) {
            char firstChar = words[i].charAt(0);
            words[i] = Character.toUpperCase(firstChar) + words[i].substring(1);
            result.append(words[i]);
            if(i != words.length - 1)
                result.append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "How can mirrors be real if our eyes aren't real";
        System.out.println(allWorldInCase(s));
        String a = "";
        System.out.println(allWorldInCase(a));
    }
}
