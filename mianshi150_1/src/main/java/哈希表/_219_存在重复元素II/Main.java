package 哈希表._219_存在重复元素II;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}

// 有一点小瑕疵, 大差不差, 滑动窗口
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> windows = new HashMap<>();
        int left = 0, right = 0;

        while (right < nums.length) {
            // 在检查是否存在重复元素时，应该在right指针增加之前检查，因为我们要确保在窗口大小超过k之前就返回true
            if (windows.containsKey(nums[right])) {
                return true;
            }
            windows.put(nums[right], right);
            right++;

            while (Math.abs(right - left) > k) {
                windows.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}