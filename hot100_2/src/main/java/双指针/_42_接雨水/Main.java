package 双指针._42_接雨水;

/**
 * @author gallantsa
 * @date 2024年04月10日 9:21
 */
public class Main {
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        int[] l_max = new int[n];
        int[] r_max = new int[n];

        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }
}