package ru.kazan.taskBigger6.DescendingOrder;

import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {

    public static int sortDesc(final int numb){
        if(numb < 0){
            return -1;
        }

        char[] arr = String.valueOf(numb).toCharArray();
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return Integer.parseInt(String.valueOf(arr));
    }

    public static int sortDescVerTwo(final int numb){
        if(numb < 0){
            return -1;
        }
        String[] arr = String.valueOf(numb).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        return Integer.parseInt(String.join("", arr));
    }

    public static void main(String[] args) {
        int numb = 123495678;

        System.out.println(sortDesc(numb));
        System.out.println(sortDescVerTwo(numb));
    }
}
