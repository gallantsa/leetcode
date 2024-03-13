package 栈._155_最小栈;

import java.util.Stack;

public class Main {
}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            stackMin.push(val);
            return;
        }

        stack.push(val);
        if (val <= stackMin.peek()) {
            stackMin.push(val);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (stackMin.peek() == pop) stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */