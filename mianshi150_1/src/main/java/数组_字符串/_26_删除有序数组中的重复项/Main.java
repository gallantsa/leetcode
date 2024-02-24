package 数组_字符串._26_删除有序数组中的重复项;

public class Main {
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        // 如果slow和fast相等, fast前进, 否则slow先前进一步, 再将fast赋值给slow
        for (; fast < nums.length; fast ++) {
            if (nums[slow] != nums[fast]) {
                slow ++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}