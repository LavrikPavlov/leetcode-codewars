package ru.kazan.level6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TribonacciSequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(tribonacciV2(new double[]{1, 1, 1}, 10)));
        System.out.println(Arrays.toString(tribonacci(new double[]{1, 1, 1}, 10)));
    }

    public static double[] tribonacci(double[] s, int n) {
        var arr = Arrays.copyOf(s, n);
        for (int i = 0; i <= n - s.length - 1; i++) {
            var sum = arr[i] + arr[i + 1] + arr[i + 2];
            arr[i + 3] = sum;
        }
        return arr;
    }

    public static double[] tribonacciV2(double[] s, int n) {
        var arr = Arrays.copyOf(s, n);
        IntStream.range(0, n - s.length)
                .forEach(i -> arr[i + 3] = arr[i] + arr[i + 1] + arr[i + 2]);
        return arr;
    }
}
