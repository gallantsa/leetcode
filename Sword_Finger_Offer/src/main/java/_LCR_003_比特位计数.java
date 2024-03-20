public class _LCR_003_比特位计数 {
}

// 动态规划!!!
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        // ans[i] = 「i >> 1 所包含的 1 的个数」+「i 的最低位是否为 1」
        for (int i = 1; i <= n; i++) ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }
}