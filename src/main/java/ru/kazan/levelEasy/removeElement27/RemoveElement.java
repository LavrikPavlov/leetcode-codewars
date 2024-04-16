package ru.kazan.levelEasy.removeElement27;

import java.util.Arrays;

public class RemoveElement {
    public static void removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j] = 0;
    }

    public static void removeElementStream(int[] nums, int val) {
        int[] result = Arrays.stream(nums)
                 .filter(num -> num != val)
                 .toArray();

        System.arraycopy(result, 0, nums, 0, result.length);
        Arrays.fill(nums, result.length, nums.length, 0);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};


        removeElementStream(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

}
