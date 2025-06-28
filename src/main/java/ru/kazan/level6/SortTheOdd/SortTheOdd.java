package ru.kazan.level6.SortTheOdd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SortTheOdd {

    public static void main(String[] args) {

    }

    public static int[] sortArray(int[] array) {
        var oddIndex = new AtomicInteger(0);
        int[] sortedOdds = IntStream.of(array)
                .filter(n -> n % 2 != 0)
                .sorted()
                .toArray();

        return IntStream.of(array)
                .map(n -> n % 2 != 0 ? sortedOdds[oddIndex.getAndIncrement()] : n)
                .toArray();
    }


}
