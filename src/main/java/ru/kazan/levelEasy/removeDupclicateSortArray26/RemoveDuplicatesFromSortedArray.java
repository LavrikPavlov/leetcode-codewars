package ru.kazan.levelEasy.removeDupclicateSortArray26;

import java.util.stream.IntStream;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicate(int[] nums){
        int leght = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i -1]) {
                nums[leght] = nums[i];
                leght++;
            }
        }
        return leght;
    }

    public static int removeDuplicateStream(int[] nums){
        return IntStream.range(0, nums.length)
                .filter(i -> i == 0 || nums[i] != nums[i - 1])
                .map(i -> nums[i])
                .toArray()
                .length;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,2,3,3,4,5,5,6,7,8,8,9};

        System.out.println(removeDuplicate(nums));

    }
}
