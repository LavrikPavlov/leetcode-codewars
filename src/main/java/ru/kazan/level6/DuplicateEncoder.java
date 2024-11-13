package ru.kazan.level6;

import java.util.stream.Collectors;

public class DuplicateEncoder {
    public static void main(String[] args) {
        var start = System.nanoTime();
        var result = encode("Prespecialized");
        var stop = System.nanoTime();
        System.out.println(result + " | " + (stop - start));

        var startV2 = System.nanoTime();
        var resultV2 = encodeV2("Prespecialized");
        var stopV2 = System.nanoTime();
        System.out.println(resultV2 + " | " + (stopV2 - startV2));
    }

    public static String encode(String word) {
        var str = new StringBuilder();
        word.toLowerCase().chars()
                .mapToLong(sym -> word.toLowerCase().chars().filter(symIn -> sym == symIn).count())
                .forEach(num -> {
                    if (num == 1L)
                        str.append("(");
                    else
                        str.append(")");
                });
        return str.toString();
    }

    public static String encodeV2(String word) {
        return word.toLowerCase()
                .chars()
                .mapToObj(sym -> String.valueOf((char) sym))
                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                .collect(Collectors.joining());

    }
}
