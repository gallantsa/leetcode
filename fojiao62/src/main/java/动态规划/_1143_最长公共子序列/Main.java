package 动态规划._1143_最长公共子序列;

public class Main {
}

class Solution {
    // dp[i][j] 含义: 长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}