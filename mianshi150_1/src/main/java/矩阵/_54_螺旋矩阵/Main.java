package 矩阵._54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 移动数组
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int n = matrix.length, m = matrix[0].length;
        // 记录走过的位置
        boolean[][] status = new boolean[n][m];
        for (int i = 0, x = 0, y = 0, a, b, d = 0; i < n * m; i++) {
            res.add(matrix[x][y]);
            // 标记走过的位置
            status[x][y] = true;
            a = x + dx[d];
            b = y + dy[d];
            // 如果越界, 或者已经走过了, 转向
            if (a < 0 || a >= n || b < 0 || b >= m || status[a][b]) {
                // 转向
                d = (d + 1) % dx.length;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}