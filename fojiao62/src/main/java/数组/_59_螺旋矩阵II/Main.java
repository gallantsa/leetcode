package 数组._59_螺旋矩阵II;

public class Main {
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] matrix = new int[n][n];

        for (int i = 1, d = 0, x = 0, a, b, y = 0; i <= n * n; i++) {
            matrix[x][y] = i;
            a = x + dx[d];
            b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= n || matrix[a][b] > 0) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return matrix;
    }
}
