package 双指针._11_盛最多水的容器;

public class Main {
}

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;

        while (left < right) {
            int cur_Area = Math.min(height[left], height[right]) * (right - left + 1);

            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
            res = Math.max(res, cur_Area);
        }
        return res;
    }
}