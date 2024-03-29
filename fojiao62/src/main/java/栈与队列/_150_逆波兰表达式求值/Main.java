package 栈与队列._150_逆波兰表达式求值;

import java.util.Stack;

public class Main {
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                stack.push(j + i + "");
            } else if (token.equals("-")) {
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                stack.push(j - i + "");
            } else if (token.equals("*")) {
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                stack.push(j * i + "");
            } else if (token.equals("/")) {
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                stack.push(j / i + "");
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}