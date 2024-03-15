package 多维动态规划._72_编辑距离;

import java.util.Arrays;

public class Main {
}

// 超时
class Solution1 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return dp(word1, m - 1, word2, n - 1);
    }

    // // 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
    private int dp(String word1, int m, String word2, int n) {
        if (m < 0) return n + 1;
        if (n < 0) return m + 1;

        if (word1.charAt(m) == word2.charAt(n)) {
            return dp(word1, m - 1, word2, n - 1);
        } else {
            return Math.min(Math.min(dp(word1, m, word2, n - 1) + 1, dp(word1, m - 1, word2, n) + 1), dp(word1, m - 1, word2, n - 1) + 1);
        }
    }
}


class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(word1, m - 1, word2, n - 1);
    }

    private int dp(String word1, int m, String word2, int n) {
        if (m < 0) return n + 1;
        if (n < 0) return m + 1;

        if (memo[m][n] != -1) return memo[m][n];

        if (word1.charAt(m) == word2.charAt(n)) {
            memo[m][n] = dp(word1, m - 1, word2, n - 1);
        } else {
            memo[m][n] = Math.min(Math.min(dp(word1, m, word2, n - 1) + 1, dp(word1, m - 1, word2, n) + 1), dp(word1, m - 1, word2, n - 1) + 1);
        }

        return memo[m][n];
    }
}