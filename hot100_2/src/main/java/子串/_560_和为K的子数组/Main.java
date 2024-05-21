package 子串._560_和为K的子数组;

/**
 * @author gallantsa
 * @date 2024年04月10日 10:12
 */
public class Main {
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}