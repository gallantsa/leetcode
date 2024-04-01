package 动态规划._416_分割等和子集;

public class Main {
}

class Solution {

    // dp[i]含义: 当背包容量为i时, 背包中物品的最大价值是dp[i]
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        int[] dp = new int[target + 1];

        // 先遍历物品, 再遍历容量
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            // 剪枝
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }
}