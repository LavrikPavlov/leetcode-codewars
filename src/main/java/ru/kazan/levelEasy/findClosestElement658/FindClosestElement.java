package ru.kazan.levelEasy.findClosestElement658;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElement {

    private static List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();
        int front = 0;
        int back = arr.length - 1;

        while (back - front >= k) {
            if (Math.abs(arr[front] - x) > Math.abs(arr[back] - x)) {
                front++;
            } else {
                back--;
            }
        }
        for (int i = front; i <= back; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(findClosestElements(arr, 3, 5));
    }

}
