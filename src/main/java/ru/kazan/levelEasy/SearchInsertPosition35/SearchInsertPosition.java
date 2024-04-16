package ru.kazan.levelEasy.SearchInsertPosition35;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        for(int i = 0; i <= nums.length - 1; i++) {
            if(nums[i] >= target) {
                return i;
            }
            if(nums[i] < target && (nums[i] > target || nums[i] == target)) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(searchInsert(nums, 0));
    }
}
