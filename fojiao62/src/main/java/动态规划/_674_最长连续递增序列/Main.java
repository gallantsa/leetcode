package 动态规划._674_最长连续递增序列;

import java.util.Arrays;

public class Main {
}

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
