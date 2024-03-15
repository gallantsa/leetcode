package 技巧._169_多数元素;

public class Main {
}

// 多数元素是指在数组中出现次数 大于 n/2 的元素。
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0; // 电性
        int target = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                target = nums[i];
                count ++;
            } else if (target == nums[i]) {
                count ++;
            } else {
                count --;
            }
        }

        return target;
    }
}