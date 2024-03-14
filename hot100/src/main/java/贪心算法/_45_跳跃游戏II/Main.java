package 贪心算法._45_跳跃游戏II;

public class Main {
}

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // end 记录等到达的最远位置
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            // 更新最远位置
            farthest = Math.max(nums[i] + i, farthest);
            // 如果已经到达最远地方, 跳
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}