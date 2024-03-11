package 动态规划._198_打家劫舍;

import java.util.Arrays;

public class Main {
}

// 超时
class Solution1 {
    public int rob(int[] nums) {
        return dp(nums, 0);
    }

    // 房子的索引是状态, 抢与不抢是选择
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        
        int res = Math.max(
                // 不抢, 去下家
                dp(nums, start + 1),
                // 抢, 去下下家
                nums[start] + dp(nums, start + 2)
        );

        return res;
    }
}

// 备忘录
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] != -1) return memo[start];
        int res = Math.max(
                // 不抢, 去下家
                dp(nums, start + 1),
                // 抢, 去下下家
                nums[start] + dp(nums, start + 2)
        );

        memo[start] = res;
        return res;
    }
}
