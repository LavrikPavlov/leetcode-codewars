package ru.kazan.level7;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListFiltering {
    public static void main(String[] args) {
        System.out.println(filterList(List.of(1, 2, "a", 0, "b")));
    }

    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(Integer.class::isInstance)
                .sorted((x, y) -> Integer.compare((Integer) x, (Integer) y))
                .collect(Collectors.toList());

        /*
         * return list.stream()
         *                 .filter(Integer.class::isInstance)
         *                 .collect(Collectors.toList());
         */
    }
}
