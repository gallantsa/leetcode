package 栈._739_每日温度;

import java.util.Stack;

public class Main {
}

class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n];
        // 栈保存数组下标, 单调递增栈
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            s.push(i);
        }
        return res;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n];

        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // 这里<=是为了更新最近一天的下标
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            res[i] = s.isEmpty() ? 0 : (s.peek() - i); // 这里(s.peek() - i)是为了求相差的天数
            s.push(i);
        }
        return res;
    }
}