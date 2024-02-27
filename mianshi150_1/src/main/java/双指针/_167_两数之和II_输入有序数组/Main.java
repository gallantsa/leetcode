package 双指针._167_两数之和II_输入有序数组;

public class Main {
}

// 双指针
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l <= r) {
            int sum = numbers[l] + numbers[r];
            if (sum < target) {
                l ++;
            } else if (sum > target) {
                r --;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{};
    }
}