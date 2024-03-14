package 多维动态规划._64_最小路径和;

import java.util.Arrays;

public class Main {
}

class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(grid, m - 1, n - 1);
    }

    private int dp(int[][] grid, int x, int y) {
        if (x == 0 && y == 0) return grid[0][0];
        if (x < 0 || y < 0) return Integer.MAX_VALUE; // 为了后面方便取小

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        memo[x][y] = Math.min(dp(grid, x - 1, y), dp(grid, x, y - 1)) + grid[x][y];
        return memo[x][y];
    }
}