package ru.kazan.level7.TwoToOne;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoToOne {

    public static void main(String[] args) {
        var s1 = "xyaabbbccccdefww";
        var s2 = "xxxxyyyyabklmopq";
        System.out.println(longest(s1, s2));
    }

    private static String longest(String s1, String s2) {
        return Stream.concat(Arrays.stream(s1.split("")), Arrays.stream(s2.split("")))
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }

}
