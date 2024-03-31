package 贪心算法._376_摆动序列;

public class Main {
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }

        // 当前差值
        int curDiff = 0;
        // 前一个差值
        int preDiff = 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];

            // 特殊平坡情况:
            // 1. 单调中间有平坡
            // 2. 上下中间有平坡
            if ((curDiff < 0 && preDiff >= 0) || (curDiff > 0 && preDiff <= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}