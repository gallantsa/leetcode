package 哈希._128_最长连续序列;

import java.util.HashSet;

public class Main {
}

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            // 找到连续序列的第一个
            if (set.contains(num - 1)) continue;

            int curNum = num;
            int curLen = 1;

            while (set.contains(curNum + 1)) {
                curLen ++;
                curNum ++;
            }
            res = Math.max(res, curLen);
        }

        return res;
    }
}