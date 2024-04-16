package ru.kazan.taskBigger6.SumOfNumbers;

public class SumOfNumbers {

    public static int getSum(int a, int b) {
        if(a==b)
            return a;

        int sum = 0;
        int first = a;
        int second = b;

        if(a > b) {
            first = b;
            second = a;
        }

        for(int i=first; i<=second; i++){
            sum += i;
        }

        return sum;
    }

    public static int getSumVersionTwo(int a, int b) {
        int res = 0;
        for(int i=Math.min(a, b); i<=Math.max(a, b); i++)
            res += i;

        return a == b ? a : res;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 0));
        // -5 -4 -3 -2 -1 0 1 2
        // -15 3
    }
}
