package 技巧._75_颜色分类;

public class Main {
}


// 荷兰旗问题
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int cur = 0;

        // 遍历数组
        while (cur <= r) {
            if (nums[cur] == 0) {
                swap(nums, cur++, l++);
            } else if (nums[cur] == 2) {
                swap(nums, cur, r--);
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}