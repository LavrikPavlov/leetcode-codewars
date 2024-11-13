package ru.kazan.level5.MaximumSubarraySum;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] mass = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getMax(mass));
    }

    private static int getMax(int[] mass){
        int maxSumGlobal = 0;
        int masFarEnding = 0;

        for (int i : mass) {
            masFarEnding = Math.max(0, masFarEnding + i);
            maxSumGlobal = Math.max(maxSumGlobal, masFarEnding);
        }
        return maxSumGlobal;
    }
}
