package ru.kazan.level4;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostFrequentlyUsedWordsInAText {

    public static void main(String[] args) {
        var test = """
                In a village of La Mancha, the name of which I have no desire to call to
                mind, there lived not long since one of those gentlemen that keep a lance
                in the lance-rack, an old buckler, a lean hack, and a greyhound for
                coursing. An olla of rather more beef than mutton, a salad on most
                nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
                on Sundays, made away with three-quarters of his income.
                """;
        System.out.println(top3(test));
    }

    public static List<String> top3(String s) {
        var pattern = Pattern.compile("[a-zA-Z']+");
        var matcher = pattern.matcher(s);

        return Stream.generate(() -> matcher.find() ? matcher.group().toLowerCase() : null)
                .takeWhile(Objects::nonNull)
                .filter(word -> word.matches(".*[a-zA-Z].*"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .parallelStream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
