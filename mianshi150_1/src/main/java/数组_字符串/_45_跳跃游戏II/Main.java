package 数组_字符串._45_跳跃游戏II;

import java.util.Arrays;

public class Main {
}

// 动态规划
class Solution2 {
    // 备忘录用来记录从当前位置最少多少步能到达结尾
    int[] memo;
    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        // 因为要求的是最小值, 所以初始化为最大值, 方便取小
        Arrays.fill(memo, n);
        return dp(nums, 0);
    }

    // 定义: 返回从位置p最少多少步到达结尾
    private int dp(int[] nums, int p) {
        int n = nums.length;
        // 如果当前位置已经越过结尾, 一步都不需要跳
        if (p >= n - 1) return 0;

        // 减少相同子问题的计算
        if (memo[p] != n) return memo[p];

        int steps = nums[p];
        // 从p位置跳跃, 可选的步长为[1..steps]
        for (int i = 1; i <= steps; i++) {
            // 穷举每一个选择, 计算每一个子问题的结果
            int subProblem = dp(nums, p + i);
            // 取其中最小的作为最终结果
            memo[p] = Math.min(memo[p], subProblem + 1);
        }
        return memo[p];
    }
}

// 贪心选择
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // end 记录可以选择的跳跃步数, farthest 标记了所有选择 [i..end] 中能够跳到的最远距离
        int end = 0, fastest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            // 更新当前位置能到达的最远距离
            fastest = Math.max(fastest, nums[i] + i);
            // 如果end == i 说明可以选择的跳跃步数已用完, 需要跳跃一次, 更新end值
            if (end == i) {
                jumps ++;
                end = fastest;
            }
        }
        return jumps;
    }
}



