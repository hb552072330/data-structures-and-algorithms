package top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Top69IsValid {
    public boolean isValid(String s) {

        if (s == null) {
            return false;
        }
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s == null) {
            return false;
        }
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')') {
                    if (!(pop == '(')) {
                        return false;
                    }
                } else if (c == ']') {

                    if (!(pop == '[')) {
                        return false;
                    }
                } else {
                    if (!(pop == '{')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
