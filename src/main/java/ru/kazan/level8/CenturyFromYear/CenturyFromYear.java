package ru.kazan.level8.CenturyFromYear;

import java.util.Arrays;

public class CenturyFromYear {

    public static void main(String[] args) {
        System.out.println(century(1900));
    }

    private static int century(int number){
        return number % 100 == 0 ? number / 100 : number / 100 + 1;
    }
}
