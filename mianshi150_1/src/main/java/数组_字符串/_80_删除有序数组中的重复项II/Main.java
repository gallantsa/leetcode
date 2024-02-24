package 数组_字符串._80_删除有序数组中的重复项II;

public class Main {
}

class Solution {
    // 这段代码中的 fast 不能从 1 开始，因为它是用来遍历整个数组 nums 的。如果 fast 从 1 开始，那么数组 nums 的第一个元素将会被跳过，不会被处理。
    // fast 必须从 0 开始，以确保数组 nums 的每一个元素都能被处理
    public int removeDuplicates(int[] nums) {
        // fast想要从1开始, 需要加上这句
        // if (nums.length == 1) return 1;
        // 这里slow和fast都从头部开始
        int slow = 0, fast = 0;
        int count = 0;
        while (fast < nums.length) {
            // 如果fast不等于slow, 那么slow向前进一步, 并将fast赋值给slow
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
                // 在fast == slow的前提下, 元素个数小于2, 依然是slow向前进一步, 并将fast赋值给slow
            } else if (slow < fast && count < 2) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;
            // fast遇到新元素那么重置count
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                count = 0;
            }
        }
        return slow + 1;
    }
}