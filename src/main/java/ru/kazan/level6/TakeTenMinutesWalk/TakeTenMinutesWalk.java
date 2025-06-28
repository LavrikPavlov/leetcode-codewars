package ru.kazan.level6.TakeTenMinutesWalk;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TakeTenMinutesWalk {

    public static void main(String[] args) {
        var inputData1 = new char[]{'s', 'w', 's', 'w', 's', 'w', 's', 'w', 's', 'w'};
        var inputData2 = new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};
        System.out.println(isValid(inputData1));
        System.out.println(isValid(inputData2));
    }

    private static boolean isValid(char[] walk) {
        if (!Objects.equals(10, walk.length))
            return false;

        return checkMap(
                Arrays.stream(String.copyValueOf(walk).split(""))
                        .collect(Collectors.groupingBy(
                                        line -> line,
                                        Collectors.counting()
                                )
                        )
        );
    }

    private static boolean checkMap(Map<String, Long> map) {
        var w = map.getOrDefault("w", 0L);
        var s = map.getOrDefault("s", 0L);
        var n = map.getOrDefault("n", 0L);
        var e = map.getOrDefault("e", 0L);
        return w.equals(e) && s.equals(n);
    }

}
