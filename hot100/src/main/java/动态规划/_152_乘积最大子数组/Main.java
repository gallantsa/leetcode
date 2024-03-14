package 动态规划._152_乘积最大子数组;

public class Main {
}

// 由于本题子数组 nums[0..i] 的最大元素积是由 nums[0..i-1] 的最大元素积推导出的, 因为元素可能为负数, 因此要同时维护dpMax和dpMin
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        for (int i = 0; i < n; i++) {
            dpMax[i] = nums[i];
            dpMin[i] = nums[i];
        }

        for (int i = 1; i < n; i++) {
            dpMax[i] = max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i]);
            dpMin[i] = min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }

    private int max(int i, int i1, int num) {
        return Math.max(Math.max(i, i1), num);
    }

    private int min(int i, int i1, int num) {
        return Math.min(Math.min(i, i1), num);
    }
}