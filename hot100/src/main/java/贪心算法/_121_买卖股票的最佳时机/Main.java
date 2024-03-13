package 贪心算法._121_买卖股票的最佳时机;

public class Main {
}

// dp[i][0] 表示第i天未持有股票
// dp[i][1] 表示第i天持有股票
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],  -prices[i]);
        }
        return dp[n - 1][0];
    }
}