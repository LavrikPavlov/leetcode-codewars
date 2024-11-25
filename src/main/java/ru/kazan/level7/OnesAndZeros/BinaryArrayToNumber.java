package ru.kazan.level7.OnesAndZeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryArrayToNumber {

    public static void main(String[] args) {
        var list = new ArrayList<>(Arrays.asList(0,1,1,0));
        System.out.println(convertBinaryArrayToInt(list));
    }

    public static int convertBinaryArrayToInt(List<Integer> binary) {
        var index = new AtomicInteger(binary.size() - 1);
        return binary.stream()
                .mapToInt(num -> num * (int) Math.pow(2, index.getAndDecrement()))
                .sum();
    }
}
