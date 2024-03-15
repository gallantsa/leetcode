package 多维动态规划._1143_最长公共子序列;

import java.util.Arrays;

public class Main {
}

// 超时
class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        return dp(text1, 0, text2, 0);
    }

    private int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp(text1, i + 1, text2, j + 1) + 1;
        } else {
            return Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
        }
    }
}

// 备忘录
class Solution {
    // 消除重叠子问题
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    // 定义: 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    private int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = dp(text1, i + 1, text2, j + 1) + 1;
        } else {
            memo[i][j] = Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
        }
        return memo[i][j];
    }
}