package ru.kazan.level6;

import java.util.Arrays;

public class ArrayDiff {
    public static void main(String[] args) {
        var arr = arrayDiff(new int [] {1, 2, 2, 2, 3}, new int[] {2});
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(num ->
                        Arrays.stream(b).noneMatch(numB -> numB == num)
                ).toArray();
    }

}
