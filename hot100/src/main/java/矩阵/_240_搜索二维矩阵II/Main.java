package 矩阵._240_搜索二维矩阵II;

public class Main {
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            // 当前值小于目标值, 向下移动
            else if (matrix[i][j] < target) {
                i ++;
            // 当前值大于目标值, 向左移动
            } else if (matrix[i][j] > target) {
                j --;
            }
        }
        return false;
    }
}