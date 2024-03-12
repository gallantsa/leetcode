package 矩阵._73_矩阵置零;

public class Main {
}

// 整体思路就是, 先判断第一行和第一列用两个flag标记是否需要置零, 并用等价的思想将非第一行非第一列为0的元素, 转变成第一行第一列为0的元素, 然后
// 根据第一行第一列的0的情况将非第一行第一列的位置置0, 最后判断第一行第一列是否需要置0
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 遍历第一行. 第一列, 若有0, 先进行标记, 之后再处理
        boolean rowFlag = false;
        boolean colFlag = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        // 等价地将非第一行非第一列为0的元素, 转变成第一行第一列为0的元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据第一行第一列的0的情况将非第一行第一列的位置置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 判断第一行第一列是否需要置0
        if (rowFlag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}