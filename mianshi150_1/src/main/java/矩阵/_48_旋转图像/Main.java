package 矩阵._48_旋转图像;

public class Main {
}

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 然后反转二维矩阵的每一行
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    // 翻转一维数组
    private void reverse(int[] matrix) {
        int n = matrix.length;
        ;
        for (int i = 0; i < n / 2; i++) {
            int temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
    }
}