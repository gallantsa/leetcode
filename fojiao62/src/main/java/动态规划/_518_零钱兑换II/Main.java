package 动态规划._518_零钱兑换II;

public class Main {
}

class Solution {
    // dp[j]含义: 凑成总金额j的货币组合数为dp[j]
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 先遍历物品, 再遍历背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}