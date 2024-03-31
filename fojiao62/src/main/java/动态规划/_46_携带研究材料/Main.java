package 动态规划._46_携带研究材料;

import java.util.Scanner;

public class Main {

    // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] weight = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = sc.nextInt();
        }
        for(int i = 0; i < m;i++) {
            value[i] = sc.nextInt();
        }
        int result = testWeightBagProblem(weight, value, n);
        System.out.println(result);
    }

    private static int testWeightBagProblem(int[] weight, int[] value, int bg) {
        int m = weight.length;
        int[][] dp = new int[m][bg + 1];

        for (int i = weight[0]; i <= bg; i++) {
            dp[0][i] = value[0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= bg; j++) {
                // 如果背包放不下当前物品, 和同容量下不放该物品一样
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果背包能放下当前物品, 可以选择放或者不放
                    // 不放: dp[i][j] = dp[i - 1][j];
                    // 放: dp[i][j] = dp[i - 1][j - weight[i]] + value[i]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        return dp[m - 1][bg];
    }
}
