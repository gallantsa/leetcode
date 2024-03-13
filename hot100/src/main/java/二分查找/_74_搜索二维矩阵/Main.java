package 二分查找._74_搜索二维矩阵;

public class Main {
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] nums = new int[m * n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[k++] = matrix[i][j];
            }
        }

        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return true;
            else if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }
        return false;
    }
}