package ru.kazan.level6.DoesMyNumberLookBigInThis;


public class DoesMyNumberLookBigInThis {

    public static boolean isNarcissistic(int number) {
        int[] numbs = String.valueOf(number).chars().map(Character::getNumericValue).toArray();

        int sum = 0;
        for(int num : numbs)
            sum += (int) Math.pow(num,numbs.length);

        return number == sum;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(1533));
    }
}
