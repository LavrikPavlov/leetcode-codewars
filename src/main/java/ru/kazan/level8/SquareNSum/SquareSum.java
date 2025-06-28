package ru.kazan.level8.SquareNSum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SquareSum {

    private static final Logger log = LoggerFactory.getLogger(SquareSum.class);

    public static void main(String[] args) {
        var inputData = new int[]{1, 2, 3};
        System.out.println(squareNSum(inputData));
    }

    public static Integer squareNSum(int[] numbers) {
        return Arrays.stream(numbers)
                .map(num -> square(num, 2))
                .reduce(0, Integer::sum);
    }

    private static Integer square(Integer num, int degree) {
        return IntStream.range(0, degree)
                .reduce(1, (acc, i) -> acc * num);
    }
}
