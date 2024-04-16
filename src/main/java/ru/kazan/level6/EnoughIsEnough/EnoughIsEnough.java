package ru.kazan.level6.EnoughIsEnough;

import java.util.*;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= elements.length - 1; i++){

            if(map.get(elements[i]) == null)
                map.put(elements[i], 1);
            else {
                int count = map.get(elements[i]);
                map.put(elements[i], ++count);
            }

            if(map.get(elements[i]) <= maxOccurrences)
                list.add(elements[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(Arrays.stream(deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3)).toArray()));
    }

}
