package 动态规划._1035_不相交的线;

public class Main {
}

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            int char1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int char2 = nums2[j - 1];
                if (char1 == char2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}