package ru.kazan.level6.PossibilitiesOfThrowingACoinNTimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibilitiesOfThrowingACoinNTimes {

    public static void main(String[] args) {
        var list = coin(5);
        Arrays.stream(list).forEach(System.out::println);
    }

    private static String[] coin(int n){
        var list = new ArrayList<String>();
        addChar(list, "", n);
        return list.toArray(String[]::new);
    }

    private static void addChar(List<String> list, String current, int n){
        if(n == 0){
            list.add(current);
            return;
        }
        addChar(list,  current + "T", n - 1);
        addChar(list, current + "H", n - 1);
    }


}
