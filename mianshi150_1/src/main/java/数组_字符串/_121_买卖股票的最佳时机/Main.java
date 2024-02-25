package 数组_字符串._121_买卖股票的最佳时机;

public class Main {
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 一维代表天数, 二维代表是否持有股票
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            // 特判, 第0天没有持有股票, 利润为0, 持有股票为-当前股票的价钱
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            // 第i天没有持有骨片, 可能昨天也没有持有股票, 或者昨天持有股票今天卖了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持有股票, 可能昨天就持有股票, 或者昨天没有持有股票, 今天刚买(注意此题至多只进行一次交易)
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        // 返回最后一天没有持有股票的情况
        return dp[n - 1][0];
    }
}