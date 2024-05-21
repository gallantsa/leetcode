package 双指针._283_移动零;

/**
 * @author gallantsa
 * @date 2024年04月10日 8:01
 */
public class Main {
}

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int i = 0, j = 1;
        while (j < n) {
            // i指0, j指非0
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
