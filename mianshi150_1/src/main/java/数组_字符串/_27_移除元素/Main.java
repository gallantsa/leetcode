package 数组_字符串._27_移除元素;

public class Main {
}

class Solution {
    public int removeElement(int[] nums, int val) {
        // 初始化双指针到nums首部, 如果fastIndex指向的数不为目标值, 将fastIndex指向的元素赋予slowIndex指向的元素, 并一起前进, 否则只需fastIndex前进
        int slowIndex = 0, fastIndex = 0;
        for (; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex ++;
            }
        }
        return slowIndex;
    }
}