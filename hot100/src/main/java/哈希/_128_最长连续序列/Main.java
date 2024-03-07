package 哈希._128_最长连续序列;

import java.util.HashSet;
import java.util.Set;

public class Main {
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            if (set.contains(num - 1)) continue;

            int len = 1;
            int curNum = num;

            while (set.contains(curNum + 1)) {
                curNum++;
                len++;
            }
            res = Math.max(res, len);
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}