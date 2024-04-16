package ru.kazan.levelEasy.mergeSortedList88;

import java.util.Arrays;

public class MergeSortedList {

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};

        mergeNew(arr1,3,arr2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr1 = Arrays.copyOf(nums1, m);
        int[] newArr2 = Arrays.copyOf(nums2, n);
        int[] result = new int[m + n];


        System.arraycopy(newArr1, 0, result, 0, m);
        System.arraycopy(newArr2, 0, result, m, n);

        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }

    public static void mergeNew(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1;
        int end2 = n - 1;
        int endResult = m + n - 1;

        while (end1 >= 0 && end2 >= 0) {
            if (nums1[end1] > nums2[end2]) {
                nums1[endResult] = nums1[end1];
                end1--;
            } else {
                nums1[endResult] = nums2[end2];
                end2--;
            }
            endResult--;
        }
        System.arraycopy(nums2, 0, nums1, 0, end2 + 1);
    }
}
