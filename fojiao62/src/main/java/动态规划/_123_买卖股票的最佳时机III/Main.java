package 动态规划._123_买卖股票的最佳时机III;

public class Main {
}

class Solution {
    // dp[i][1]，表示的是第i天，买入股票的状态，并不是说一定要第i天买入股票，这是很多同学容易陷入的误区。
    // 五种状态:
    // 0: 没有操作 （其实我们也可以不设置这个状态）
    // 1: 第一次持有股票
    // 2: 第一次不持有股票
    // 3: 第二次持有股票
    // 4: 第二次不持有股票
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];

        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[n - 1][4];
    }
}