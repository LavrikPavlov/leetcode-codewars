package ru.kazan.level7.BinaryAddition;

public class BinaryAddition {

    public static void main(String[] args) {
        System.out.println(sumInBinary(1, 1));
    }

    private static String sumInBinary(int a, int b){
        return Integer.toBinaryString(a + b);
    }
}
