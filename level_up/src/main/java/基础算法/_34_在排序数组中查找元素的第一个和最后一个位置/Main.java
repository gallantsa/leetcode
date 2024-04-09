package 基础算法._34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * @author gallantsa
 * @date 2024年04月09日 10:08
 */
public class Main {
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = -1, r = n;
        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            // 找到第一个大于等于target的下标
            if (nums[mid] >= target) r = mid;
            else l = mid;
        }
        int start = r;
        if (start == n) return new int[]{-1, -1};
        l = -1;
        r = n;
        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            // 找到第一个小于等于target的下标
            if (nums[mid] <= target) l = mid;
            else r = mid;
        }
        int end = l;
        if ( end == -1 || nums[l] != target) return new int[]{-1, -1};
        else return new int[]{start, end};
    }
}