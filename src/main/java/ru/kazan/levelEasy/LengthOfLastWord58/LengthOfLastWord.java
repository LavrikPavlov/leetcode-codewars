package ru.kazan.levelEasy.LengthOfLastWord58;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] mass = s.split(" ");
        return mass[mass.length - 1].length();
    }

    public static int lengthOfLastWordOptimaze(String s) {
        int lenght = 0;
        String worlds = s.trim();
        for (int i = worlds.length() - 1; i >= 0; i--) {
            if(worlds.charAt(i) == ' ') {
                break;
            }
            lenght++;
        }
        return lenght;
    }

    public static void main(String[] args) {
        String worlds = "Hello World ";
        System.out.println(lengthOfLastWordOptimaze(worlds));
    }
}
