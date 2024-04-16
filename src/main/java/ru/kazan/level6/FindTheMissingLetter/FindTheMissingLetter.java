package ru.kazan.level6.FindTheMissingLetter;

import java.util.*;

public class FindTheMissingLetter {

    private static char findMissingLetter(char[] array){
        List<Character> list= new ArrayList<>();

        for(char start = array[0]; start <= array[array.length-1]; start++)
            list.add(start);

        for(int i = 0, j = list.indexOf(array[0]); i <= array.length - 1; i++, j++){
            if(list.get(j) != Character.valueOf(array[i]))
                return list.get(j);
        }
        return ' ';
    }

    public static char findMissingLetter2(char[] array){
        char expiredLetter = array[0];
        for(char letter : array){
            if(letter != expiredLetter)
                return expiredLetter;
            expiredLetter++;
        }
        return expiredLetter;
    }

    public static void main(String[] args) {
        char[] array = {'a','b','c','d','f'};
        System.out.println(findMissingLetter(array));
        System.out.println(findMissingLetter2(array));
    }
}
