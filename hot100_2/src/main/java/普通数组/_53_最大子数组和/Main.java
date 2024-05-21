package 普通数组._53_最大子数组和;

/**
 * @author gallantsa
 * @date 2024年04月12日 17:24
 */
public class Main {
}

class Solution {
    // dp[i]含义: 以i下标为结尾的数组的最大子数组和
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }

        return res;
    }
}