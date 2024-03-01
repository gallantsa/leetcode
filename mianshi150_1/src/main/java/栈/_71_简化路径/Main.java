package 栈._71_简化路径;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
    }
}

class Solution {
    public String simplifyPath(String path) {
        // 先分隔
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        String res = "";

        for (int i = 0; i < split.length; i++) {
            // 如果当前字符串为空或者是., 跳过
            if (split[i].equals("") || split[i].equals(".")) continue;
            // 如果当前字符串为.., 且栈不为空弹出栈顶目录, 跳过, 如果栈顶为空, 且栈顶为空不合法, 因为无法前往根目录更前的目录, 也直接跳过
            if (split[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(split[i]);
        }

        // 遍历栈, 判空
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.equals("") ? "/" : res;
    }
}