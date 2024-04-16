package ru.kazan.level5.WeightForWeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightForWeight {

    public static String orderWeight(String string) {
        String[] numbArray = string.split(" ");

        return Arrays.stream(numbArray).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i1 = Arrays.stream(o1.split(""))
                        .mapToInt(Integer::parseInt)
                        .sum();

                int i2 = Arrays.stream(o2.split(""))
                        .mapToInt(Integer::parseInt)
                        .sum();

                if(i1 != i2)
                    return Integer.compare(i1, i2);
                else
                    return o1.compareTo(o2);

            }
        }).collect(Collectors.joining(" ")).trim();
    }

    public static void main(String[] args) {
        String s1 = "103 123 4444 99 2000";
        String s2 = "2000 10003 1234000 44444444 9999 11 11 22 123";
        System.out.println(orderWeight(s1));
        System.out.println(orderWeight(s2));
    }
}
