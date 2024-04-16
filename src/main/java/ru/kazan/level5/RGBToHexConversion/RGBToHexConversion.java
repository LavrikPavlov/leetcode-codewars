package ru.kazan.level5.RGBToHexConversion;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RGBToHexConversion {

    public static String rgb(int r, int g, int b){
        StringBuilder sb = new StringBuilder();
        int[] arrayNumb = {r, g, b};

        for (int num : arrayNumb) {
            if (num <= 0)
                sb.append("00");
            else if (num >= 255)
                sb.append("FF");
            else {
                String color = Integer.toHexString(num);
                if (color.length() == 1)
                    color = "0" + color;
                sb.append(color);
            }
        }
        return sb.toString().toUpperCase();
    }

    public static String rgbVerTwo(int r, int g, int b){
        return Stream.of(r,g,b)
                .map(num -> Math.max(0, num))
                .map(num -> Math.min(255, num))
                .map(num -> String.format("%02X", num))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(rgb(-20, 275, 125));
        System.out.println(rgbVerTwo(-20, 275, 125));
    }

}
