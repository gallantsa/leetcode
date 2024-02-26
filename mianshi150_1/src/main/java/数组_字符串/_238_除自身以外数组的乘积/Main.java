package 数组_字符串._238_除自身以外数组的乘积;

public class Main {
}

// 前缀和
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        int tmp = 1;
        // 自上而下求下三角的值
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // 自下而上将同一行的两个三角形的值相乘
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }
        return ans;
    }
}