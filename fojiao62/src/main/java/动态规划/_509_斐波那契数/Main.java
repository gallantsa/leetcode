package 动态规划._509_斐波那契数;

public class Main {
}

class Solution {
    public int fib(int n) {
        // 防止n为0时, 数组越界
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}