package 贪心算法._55_跳跃游戏;

public class Main {
}

class Solution1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到0卡住不动了
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}