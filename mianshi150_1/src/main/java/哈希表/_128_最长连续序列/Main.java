package 哈希表._128_最长连续序列;

import java.util.HashSet;
import java.util.Set;

public class Main {
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            // 如果不是最长连续序列的开始数字, 跳过
            if (set.contains(num - 1)) continue;

            int curNum = num;
            int curLen = 1;

            // 统计连续序列长度
            while (set.contains(curNum + 1)) {
                curNum += 1;
                curLen += 1;
            }
            // 更新最长连续序列长度
            res = Math.max(res, curLen);
        }
        return res;
    }
}
