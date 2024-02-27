package 数组_字符串._42_接雨水;

public class Main {
}

// 暴力解法
class Solution1 {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        // 开头和结尾盛不了水
        for (int i = 1; i < n - 1; i++) {
            int l_max = 0, r_max = 0;

            // 求当前位置右边最高的柱子
            for (int j = i; j < n; j++) {
                r_max = Math.max(r_max, height[j]);
            }

            // 求当前位置左边最高的柱子
            for (int j = i; j >= 0; j--) {
                l_max = Math.max(l_max, height[j]);
            }

            // 收集雨水
            res += Math.min(r_max, l_max) - height[i];
        }
        return res;
    }
}

// 备忘录写法
class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int[] l_max = new int[n];
        int[] r_max = new int[n];

        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }
}

// 双指针
class Solution {
    public int trap(int[] height) {
        // left 和 right 分别从数组的两端开始，向中间移动。
        int left = 0, right = height.length - 1;
        // l_max 和 r_max 分别记录了从左边和右边看到的最高的墙的高度
        int l_max = 0, r_max = 0;

        int res = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            // 如果 l_max 较小，那么我们就移动左指针，并且我们知道它能够接的雨水的量就是 l_max - height[left]，因为右边有一个更高的墙 r_max 可以阻止水流出去。
            if (l_max < r_max) {
                res += l_max - height[left];
                left ++;
            } else {
                res += r_max - height[right];
                right --;
            }
        }
        return res;
    }
}