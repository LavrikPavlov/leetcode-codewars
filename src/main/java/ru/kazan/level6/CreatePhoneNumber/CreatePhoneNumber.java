package ru.kazan.level6.CreatePhoneNumber;

import java.util.stream.IntStream;

public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'(', ')', ' ', '-'};
        int j = 0;

        for (int i = 0; i < numbers.length; i++){
            if(i == 0 || i == 3 || i == 6) {
                sb.append(chars[j]);
                j++;
                if(i == 3) {
                    sb.append(chars[j]);
                    j++;
                }
            }
            sb.append(numbers[i]);

        }

        return sb.toString();
    }

    public static String createPhoneNumberVerTwo(int[] numbers){
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
    }

    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println(createPhoneNumberVerTwo(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
