package ru.kazan.level6.YourOrderPlease;

import java.util.Arrays;
import java.util.Comparator;

public class YourOrderPlease {

    public static String order(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(
                        YourOrderPlease::extractOrder))
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }

    private static int extractOrder(String word) {
        String digits = word.replaceAll("\\D", "");
        return Integer.parseInt(digits);
    }

    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
        System.out.println(order("4of Fo1r pe6ople g3ood th5e the2"));
    }

}
