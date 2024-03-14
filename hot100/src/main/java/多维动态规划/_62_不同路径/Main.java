package 多维动态规划._62_不同路径;

public class Main {
}

// 超时
class Solution1 {
    public int uniquePaths(int m, int n) {
        return dp(m - 1, n - 1);
    }

    // 定义: 从 (0, 0) 到 (x, y) 有 dp(x, y) 条路径
    private int dp(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }

        if (x < 0 || y < 0) return 0;

        // 状态转移方程
        // 到达 (x, y) 的路径数等于到达 (x - 1, y) 和 (x, y - 1) 路径数之和
        return dp(x - 1, y) + dp(x, y - 1);
    }
}

// 备忘录
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dp(m - 1, n - 1);
    }

    private int dp(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }

        if (x < 0 || y < 0) return 0;

        if (memo[x][y] != 0) return memo[x][y];

        // 状态转移方程
        // 到达 (x, y) 的路径数等于到达 (x - 1, y) 和 (x, y - 1) 路径数之和
        memo[x][y] = dp(x - 1, y) + dp(x, y - 1);
        return memo[x][y];
    }
}