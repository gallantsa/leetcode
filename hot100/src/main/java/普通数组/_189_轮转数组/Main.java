package 普通数组._189_轮转数组;

import java.util.Arrays;

public class Main {
}

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // 拷贝数组
        int[] ints = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = ints[i];
        }
    }
}