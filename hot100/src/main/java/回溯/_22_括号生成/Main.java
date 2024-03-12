package 回溯._22_括号生成;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        backtrack(n, n);
        return res;
    }

    private void backtrack(int left, int right) {
        // 当剩下没加的左括号大于右括号说明不合法
        if (right < left) return;
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        // 这里的代码相当于 for choice in ['(', ')']
        sb.append('(');
        backtrack(left - 1, right);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backtrack(left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}