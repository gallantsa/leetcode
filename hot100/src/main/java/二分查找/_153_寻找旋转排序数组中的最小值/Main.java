package 二分查找._153_寻找旋转排序数组中的最小值;

public class Main {
}

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        // 这里定义旋点为最大值
        // 找旋点, l为旋点的下一个, 也就是最小值, 如果数组完全递增, 则最后 l == n
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= nums[0]) l = mid + 1;
            else r = mid - 1;
        }
        return l == n ? nums[0] : nums[l];
    }
}