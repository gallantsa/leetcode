package 数组_字符串._189_轮转数组;

import java.util.Arrays;

public class Main {
}

class Solution {
    public void rotate(int[] nums, int k) {
        // k可能会大于数组长度, 因此先取模进行等价替换
        k = k % nums.length;
        // 先拷贝数组
        int[] copy = Arrays.copyOf(nums, nums.length);
        // 原来数组相应的位置填上元素
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = copy[i];
        }
    }
}