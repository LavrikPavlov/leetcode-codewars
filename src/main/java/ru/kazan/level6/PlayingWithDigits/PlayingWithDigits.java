package ru.kazan.level6.PlayingWithDigits;


public class PlayingWithDigits {

    public static long playingWithDigits(int n, int p) {
        char[] digits = String.valueOf(n).toCharArray();
        int[] numbers = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            numbers[i] = Integer.parseInt("" + digits[i]);
        }

        int result = 0;
        for (int number : numbers) {
            result += (int) Math.pow(number, p);
            p++;
        }
        if(result % n == 0)
            return result / n;
        else
            return -1;
    }

    public static long playingWithDigitsVerTwo(int n, int p) {
        String digits = String.valueOf(n);
        int result = 0;
        for (int i = 0; i < digits.length(); i++, ++p) {
            result += (int) Math
                    .pow(Character.getNumericValue(digits.charAt(i)), p);
        }

        if(result % n == 0)
            return result / n;
        else
            return -1;
    }

    public static void main(String[] args) {
        int numb = 46288;
        int p = 3;
        System.out.println(playingWithDigitsVerTwo(numb, p));
    }
}
