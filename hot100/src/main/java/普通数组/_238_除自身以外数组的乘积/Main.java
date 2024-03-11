package 普通数组._238_除自身以外数组的乘积;

public class Main {
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int[] res = new int[n];

        pre[0] = 1;
        post[n - 1] = 1;

        // 前缀积
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        // 后缀积
        for (int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }
        // 求结果
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}