package 栈._394_字符串解码;

import java.util.Stack;

public class Main {
}

class Solution1 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();

        int num = 0;
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_res = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(num);
                stack_res.push(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_num = stack_multi.pop();
                for (int i = 0; i < cur_num; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}