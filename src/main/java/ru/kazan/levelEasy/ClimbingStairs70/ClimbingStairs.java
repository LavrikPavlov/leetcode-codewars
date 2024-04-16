package ru.kazan.levelEasy.ClimbingStairs70;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(7));
    }
}
