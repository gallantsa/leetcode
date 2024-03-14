package 动态规划._300_最长递增子序列;

import java.util.Arrays;

public class Main {
}

// 最长递增子序列长度, 一定在以每个数字为结尾的最长子序列长度之中, 这就是局部最优解得到全局最优解, 符合最有子结构
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // 外层循环的目的是遍历每个元素，以便确定以当前元素结尾的最长递增子序列的长度。
        for (int i = 0; i < n; i++) {
            // 内层循环用于寻找在 nums[i] 之前的所有元素中小于 nums[i] 的元素，这是因为我们需要考虑这些元素是否可以被添加到当前正在构建的递增子序列中。
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
