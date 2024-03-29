package 栈与队列._20_有效的括号;

import java.util.Stack;

public class Main {
}

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;

            if (c == ')') {
                if (stack.peek() != '(') return false;
                stack.pop();
            } else if (c == '}') {
                if (stack.peek() != '{') return false;
                stack.pop();
            } else {
                if (stack.peek() != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}