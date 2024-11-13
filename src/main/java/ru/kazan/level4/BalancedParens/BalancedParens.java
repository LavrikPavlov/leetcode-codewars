package ru.kazan.level4.BalancedParens;

import java.util.ArrayList;
import java.util.List;

public class BalancedParens {

    public static void main(String[] args) {
        var test = balancedParens(3);
        System.out.println(test);
    }

    public static List<String> balancedParens(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "", n, n);
        return list;
    }

    private static void generate(List<String> parrens, String result, int close, int open) {
        if(open == 0 && close == 0)
            parrens.add(result);

        if(open > 0)
            generate(parrens, result + "(", close, open -1);

        if(close > open){
            generate(parrens, result + ")", close - 1, open);
        }
    }


}
