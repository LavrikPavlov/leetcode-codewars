package ru.kazan.level8.GrasshopperSummation;


import java.util.Objects;
import java.util.stream.IntStream;

public class GrasshopperSummation {

    public static void main(String[] args) {
        System.out.println(summation(8));
        System.out.println(summationV2(8));
    }

    private static int summation(int n){
        return IntStream.range(1, n + 1)
                .reduce(0, Integer::sum);
    }

    private static int summationV2(int n){
        return Objects.equals(1, n) ? 1 : n + summation(n - 1);
    }
}
