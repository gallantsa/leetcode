package 双指针._283_移动零;

public class Main {
}

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == 0) {
                if (nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }
    }
}