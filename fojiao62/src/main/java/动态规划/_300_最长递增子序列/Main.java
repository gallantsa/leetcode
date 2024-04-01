package 动态规划._300_最长递增子序列;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}

class Solution {

    // dp[i]含义: 以第i个元素为结尾的最长递增子序列的长度
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}