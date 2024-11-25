package ru.kazan.level6;

public class PersistentBugger {
    public static void main(String[] args) {
        System.out.println(persistence( 39));
    }

    public static int persistence(long n) {
        var index = 0;
        while (n >= 10) {
            n = String.valueOf(n).chars()
                    .map(Character::getNumericValue)
                    .reduce(1, (a, b) -> a * b);
            System.out.println(n);
            index++;
        }
        return index;
    }
}
