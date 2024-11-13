package ru.kazan.level7.ShortestWord;

import java.util.Arrays;

public class FindShortWord {
    public static void main(String[] args) {
        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps"));
    }

    public static int findShort(String str) {
        return Arrays.stream(str.split(" ")).sorted((o1, o2) -> {
            if(o1.length() > o2.length())
                return 1;
            if(o1.length() < o2.length())
                return -1;
            return 0;
        })
                .findFirst()
                .get()
                .length();
    }

    public static int findShortV2(String str){
        return Arrays.stream(str.split(" ")).mapToInt(String::length).min().getAsInt();
    }

}
