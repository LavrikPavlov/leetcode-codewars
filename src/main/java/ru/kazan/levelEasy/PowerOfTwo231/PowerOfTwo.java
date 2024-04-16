package ru.kazan.levelEasy.PowerOfTwo231;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
            return (n & (n - 1)) == 0 && !(n <= 0);
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < 100){
            System.out.println(i +" | "+isPowerOfTwo(i));
            i++;
        }
    }
}
