package ru.kazan.level6.WhoLikesIt;

import java.util.ArrayList;
import java.util.List;

public class WhoLikesIt {


    public static String whoLikesIt(String[] names) {
        final String LIKE_THIS = " like this";
        final String LIKES_THIS = " likes this";

        return switch (names.length) {
            case 0 -> "no one" + LIKES_THIS;
            case 1 -> names[0] + LIKES_THIS;
            case 2 -> names[0] + " and " + names[1] + LIKE_THIS;
            case 3 -> names[0] + ", " + names[1] + " and " + names[2] + LIKE_THIS;
            default -> names[0] + ", " + names[1] + " and " + (names.length - 2) + " others" + LIKE_THIS;
        };


    }


    public static void main(String[] args) {
        List<String[]> listNames = new ArrayList<>();

        listNames.add(new String[]{""});
        listNames.add(new String[]{"Peter"});
        listNames.add(new String[]{"Jacob", "Alex"});
        listNames.add(new String[]{"Jacob", "Alex", "Mark"});
        listNames.add(new String[]{"Alex", "Jacob", "Mark", "Max"});

        for (String[] names : listNames) {
            System.out.println(whoLikesIt(names));
        }
    }
}
