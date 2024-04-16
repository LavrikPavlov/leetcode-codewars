package ru.kazan.level6.ValidBraces;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBraces {

    public static boolean isValid(String braces) {
        Map<Character, Character> map = new HashMap<>();

        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < braces.length(); i++) {
            Character currentChar = braces.charAt(i);
            if(map.containsKey(currentChar))
                stack.push(currentChar);
            else
                if (stack.isEmpty() || map.get(stack.pop()) != currentChar)
                    return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValidTwo(String braces){
        Stack<Character> stack = new Stack<>();

        for(char c : braces.toCharArray()){
            if(!stack.isEmpty() && isClosing(stack.peek(), c))
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }

    public static boolean isClosing(char x, char c) {
        return (x == '{' && c == '}') ||
                (x == '(' && c == ')') ||
                (x == '[' && c == ']');
    }

    public static void main(String[] args) {

        System.out.println(isValidTwo("(){}[]")); // true
        System.out.println(isValidTwo("([{}])")); // true
        System.out.println(isValidTwo("([)]"));   // false
        System.out.println(isValidTwo("((("));
    }
}
