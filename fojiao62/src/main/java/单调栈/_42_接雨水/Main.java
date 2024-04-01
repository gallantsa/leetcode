package 单调栈._42_接雨水;

public class Main {
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左到右, 找到每个位置左边最高的柱子(包含自己)
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        // 同理
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }
}