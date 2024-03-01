package 栈._150_逆波兰表达式求值;

import java.util.Stack;

public class Main {
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                Integer y = stack.pop();
                Integer x = stack.pop();
                stack.push(x + y);
            } else if (tokens[i].equals("-")) {
                Integer y = stack.pop();
                Integer x = stack.pop();
                stack.push(x - y);
            } else if (tokens[i].equals("*")) {
                Integer y = stack.pop();
                Integer x = stack.pop();
                stack.push(x * y);
            } else if (tokens[i].equals("/")) {
                Integer y = stack.pop();
                Integer x = stack.pop();
                stack.push(x / y);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}