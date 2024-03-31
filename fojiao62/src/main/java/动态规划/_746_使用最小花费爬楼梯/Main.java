package 动态规划._746_使用最小花费爬楼梯;

public class Main {
}

class Solution {

    // dp[i] 含义: 到达第i台阶的最小花费
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        // 从下标为 0 或下标为 1 的台阶开始，因此支付费用为0
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}