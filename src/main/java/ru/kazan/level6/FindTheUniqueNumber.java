package ru.kazan.level6;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FindTheUniqueNumber {
    public static void main(String[] args) {

    }

    public static double findUniq(double arr[]) {
        var list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        num-> num, Collectors.counting()
                ));

        return list.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0.0);
    }
}
