package 矩阵._54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;;
        int n = matrix[0].length;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] status = new boolean[m][n];
        for (int i = 0, x = 0, y = 0, a, b, d = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            status[x][y] = true;
            a = x + dx[d];
            b = y + dy[d];
            if (a < 0 || a >= m || b < 0 || b >= n || status[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;;
        int n = matrix[0].length;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] status = new boolean[m][n];

        for (int i = 0, x = 0, y = 0, a, b, d = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            status[x][y] = true;
            a = x + dx[d];
            b = y + dy[d];

            // 转向
            if (a < 0 || a >= m || b < 0 || b >= n || status[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}