package 双指针._11_盛最多水的容器;

public class Main {
}

// 双指针
class Solution1 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            // 计算当前区域的面积
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            // 更新最大面积
            res = Math.max(cur_area, res);

            // 移动短的柱子
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return res;
    }
}