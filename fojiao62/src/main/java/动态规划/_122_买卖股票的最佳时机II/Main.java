package 动态规划._122_买卖股票的最佳时机II;

public class Main {
}

class Solution {
    // dp[i][0]含义: 表示第i天, 未持有股票获得的最佳利润
    // dp[i][1]含义: 表示第i天, 持有股票获得的最佳利润
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}