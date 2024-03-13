package 二分查找._34_在排序数组中查找元素的第一个和最后一个位置;

public class Main {
}

class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    private int right_bound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        // 检查出界情况
        if (r < 0 || nums[r] != target) return -1;

        return r;
    }

    private int left_bound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) r = mid - 1;
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }

        // 检查出界情况
        if (l >= nums.length || nums[l] != target) return -1;
        return l;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    private int right_bound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) l = mid + 1;
            else if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }
        // 检查出界情况
        if (r - 1 < 0 || nums[r - 1] != target) return -1;

        return r - 1;
    }

    private int left_bound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) r = mid;
            else if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }

        // 检查出界情况
        if (l >= nums.length || nums[l] != target) return -1;
        return l;
    }
}
