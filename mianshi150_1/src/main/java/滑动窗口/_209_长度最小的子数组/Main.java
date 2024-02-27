package 滑动窗口._209_长度最小的子数组;

public class Main {
}

// 滑动窗口
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int windows = 0;
        // 方便取小
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            windows += nums[right];
            // 扩大窗口
            right ++;

            while (windows >= target) {
                res = Math.min(res, right - left);
                windows -= nums[left];
                // 缩小窗口
                left ++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}