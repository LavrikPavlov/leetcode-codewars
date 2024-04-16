package ru.kazan.levelEasy.FindIndexOfTheFirstOccurrenceString28;

public class FindIndexOfTheFirstOccurrenceString {

    public static int strStr(String haystack, String needle) {
        int j = 0;
        boolean found = false;
        for (int i = 0; i < haystack.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1)
                    return i - j;
                j++;
                found = true;
            } else {
                if (found)
                    i -= j;
                found = false;
                j = 0;
            }
        }
        return -1;
    }
    
    public static int strStrVersionTwo(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";
        System.out.println(strStr(haystack, needle));
        System.out.println(strStrVersionTwo(haystack, needle));
    }
}
