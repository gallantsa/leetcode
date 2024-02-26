package 数组_字符串._55_跳跃游戏;

public class Main {
}

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int fastest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算最远距离, i + nums[i] 为当前位置能到达的最远距离
            fastest = Math.max(fastest, i + nums[i]);
            // 如果最远距离到不了当前距离, 自然而然到不了更远的距离(当前距离<=最后)
            if (fastest <= i) return false;
        }
        return fastest >= n - 1;
    }
}
