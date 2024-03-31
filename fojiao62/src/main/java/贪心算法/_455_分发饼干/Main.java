package 贪心算法._455_分发饼干;

import java.util.Arrays;

public class Main {
}

class Solution {
    // g是胃口, s是饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        // 记录饼干开始的位置
        int start = s.length - 1;

        for (int i = g.length - 1; i >= 0; i--) {
            if (start >= 0 && g[i] <= s[start]) {
                count++;
                start--;
            }
        }
        return count;
    }
}