package ru.kazan.level6.FindThe0ddInt;

import java.util.Arrays;

public class FindThe0ddInt {

    public static void main(String[] args) {
        var arr = new int[] {1,2,2,3,3,3,4,3,3,3,2,2,1};

        System.out.println(findIt(arr));
    }

    public static int findIt(int[] a) {
            return Arrays.stream(a).reduce(0, (x, y) -> x ^ y);
    }
}
