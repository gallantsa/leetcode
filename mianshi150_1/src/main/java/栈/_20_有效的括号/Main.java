package 栈._20_有效的括号;

import java.util.Stack;

public class Main {
}

class Solution {
    public boolean isValid(String s) {
        // 1. 字符串长度为奇数, 返回false
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 2. 左括号直接入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            // 3. 栈为空, 但是该字符为右括号, 返回false
            if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')) return false;
            // 4. 下面的情况都是栈不为空, 且当前字符为右括号, 直接匹配出栈
            if (c == ')') {
                if (stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
            if (c == '}') {
                if (stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
            if (c == ']') {
                if (stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        // 5. 最后栈空则合法
        return stack.isEmpty();
    }
}