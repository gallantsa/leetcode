package 二分查找._35_搜索插入位置;

public class Main {
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        return left_bound(nums, target);
    }

    private int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // [left, right)

        // 当left == right是, 区间为[left, left)空集退出循环
        while (left < right) {
            int mid = (left + right) >> 1;// 因为右开, 这里left + right不需要+1, 否则mid可能等于right, 导致索引越界
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid; // 因为右开
            else left = mid + 1; // 因为左闭
        }
        return left;
    }
}