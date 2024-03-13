package 二分查找._33_搜索旋转排序数组;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{1,3}, 1));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int l = 0, r = n - 1;

        // 找旋点
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= nums[0]) l = mid + 1;
            else r = mid - 1;
        }

        // 选择二分区域
        if (target >= nums[0]) {
            l = 0;
        } else {
            r = n - 1;
        }

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else return mid;
        }
        return -1;
    }
}
