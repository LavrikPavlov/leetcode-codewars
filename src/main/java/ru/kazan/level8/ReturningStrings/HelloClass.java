package ru.kazan.level8.ReturningStrings;

public class HelloClass {

    public static void main(String[] args) {
        System.out.println(greet("Mikhail"));
    }

    public static String greet(String name) {
        return String.format("Hello, %s how are you doing today?", name);
    }
}
