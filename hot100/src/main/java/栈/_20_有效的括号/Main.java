package 栈._20_有效的括号;

import java.util.Stack;

public class Main {
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
                continue;
            }
            if (stack.isEmpty()) return false;
            if (cur == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (cur == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (cur == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}